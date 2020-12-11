package com.qh.venus.achilles.framework.log.aspect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.util.ObjectUtil;
import com.qh.venus.achilles.framework.security.AuthUser;
import com.qh.venus.achilles.framework.security.service.TokenService;
import org.apache.catalina.util.RequestUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.qh.venus.achilles.common.constant.Constants;
import com.qh.venus.achilles.common.spring.SpringContextHolder;
import com.qh.venus.achilles.common.utils.ServletUtils;
import com.qh.venus.achilles.common.utils.StringUtils;
import com.qh.venus.achilles.common.utils.ip.AddressUtils;
import com.qh.venus.achilles.common.utils.ip.IpUtils;
import com.qh.venus.achilles.framework.log.annotation.OperLog;
import com.qh.venus.achilles.framework.log.enums.BusinessStatus;
import com.qh.venus.achilles.framework.log.event.SysOperLogEvent;
import com.qh.venus.achilles.sms.system.domain.SysOperLog;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title:操作日志记录处理
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@Aspect
@Slf4j
public class OperLogAspect {
	@Autowired
	TokenService tokenService;
	// 配置织入点
	@Pointcut("@annotation(com.qh.venus.achilles.framework.log.annotation.OperLog)")
	public void logPointCut() {
	}

	/**
	 * 处理完请求后执行
	 *
	 * @param joinPoint
	 *            切点
	 */
	@AfterReturning(pointcut = "logPointCut()")
	public void doAfterReturning(JoinPoint joinPoint) {
		handleLog(joinPoint, null);
	}

	/**
	 * 拦截异常操作
	 *
	 * @param joinPoint
	 *            切点
	 * @param e
	 *            异常
	 */
	@AfterThrowing(value = "logPointCut()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
		handleLog(joinPoint, e);
	}

	protected void handleLog(final JoinPoint joinPoint, final Exception e) {
		try {
			// 获得注解
			OperLog controllerLog = getAnnotationLog(joinPoint);
			if (ObjectUtil.isNull(controllerLog)) {
				return;
			}
			// *========数据库日志=========*//
			SysOperLog operLog = new SysOperLog();
			operLog.setStatus(BusinessStatus.SUCCESS.ordinal());
			// 请求的地址
			HttpServletRequest request = ServletUtils.getRequest();
			String ip = IpUtils.getIpAddr(request);
			operLog.setOperIp(ip);
			operLog.setOperUrl(request.getRequestURI());
			operLog.setOperLocation(AddressUtils.getRealAddressByIP(ip));
			String username = null;
			AuthUser authUser = tokenService.getLoginUser(ServletUtils.getRequest());
			if(ObjectUtil.isNotNull(authUser)){
				username = authUser.getUsername();
			}
			operLog.setOperName(username);
			if (ObjectUtil.isNotNull(e)) {
				operLog.setStatus(BusinessStatus.FAIL.ordinal());
				operLog.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
			}
			// 设置方法名称
			String className = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			operLog.setMethod(className + "." + methodName + "()");
			// 设置请求方式
			operLog.setRequestMethod(request.getMethod());
			// 处理设置注解上的参数
			Object[] args = joinPoint.getArgs();
			getControllerMethodDescription(controllerLog, operLog, args);
			// 发布事件
			SpringContextHolder.publishEvent(new SysOperLogEvent(operLog));
		} catch (Exception exp) {
			// 记录本地异常日志
			log.error("==前置通知异常==");
			log.error("异常信息:{}", exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 *
	 * @param log
	 *            日志
	 * @param operLog
	 *            操作日志
	 * @throws Exception
	 */
	public void getControllerMethodDescription(OperLog log, SysOperLog operLog, Object[] args) throws Exception {
		// 设置action动作
		operLog.setBusinessType(log.businessType().ordinal());
		// 设置标题
		operLog.setTitle(log.title());
		// 设置操作人类别
				operLog.setOperatorType(log.operatorType().ordinal());
		// 是否需要保存request，参数和值
		if (log.isSaveRequestData()) {
			// 获取参数的信息，传入到数据库中。
			setRequestValue(operLog, args);
		}
	}

	/**
	 * 获取请求的参数，放到log中
	 *
	 * @param operLog
	 *            操作日志
	 * @throws Exception
	 *             异常
	 */
	private void setRequestValue(SysOperLog operLog, Object[] args) throws Exception {
		List<?> param = new ArrayList<>(Arrays.asList(args)).stream().filter(p -> !(p instanceof ServletResponse))
				.collect(Collectors.toList());
		log.debug("args:{}", param);
		String params = JSON.toJSONString(param, true);
		operLog.setOperParam(StringUtils.substring(params, 0, 2000));
	}

	/**
	 * 是否存在注解，如果存在就获取
	 */
	private OperLog getAnnotationLog(JoinPoint joinPoint) throws Exception {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		if (method != null) {
			return method.getAnnotation(OperLog.class);
		}
		return null;
	}
}

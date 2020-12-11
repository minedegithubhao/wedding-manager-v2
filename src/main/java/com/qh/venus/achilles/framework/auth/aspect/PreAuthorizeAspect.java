package com.qh.venus.achilles.framework.auth.aspect;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.util.ObjectUtil;
import com.qh.venus.achilles.framework.security.AuthUser;
import com.qh.venus.achilles.framework.security.service.TokenService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qh.venus.achilles.common.constant.Constants;
import com.qh.venus.achilles.common.utils.ServletUtils;
import com.qh.venus.achilles.framework.auth.annotation.HasPermissions;
import com.qh.venus.achilles.framework.web.exception.ForbiddenException;
import com.qh.venus.achilles.sms.system.service.ISysMenuService;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title:权限
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@Aspect
@Component
@Slf4j
public class PreAuthorizeAspect {
	@Autowired
	private ISysMenuService sysMenuService;
	@Autowired
	private TokenService tokenService;
	@Around("@annotation(com.qh.venus.achilles.framework.auth.annotation.HasPermissions)")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		Signature signature = point.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		HasPermissions annotation = method.getAnnotation(HasPermissions.class);
		if (annotation == null) {
			return point.proceed();
		}
		String authority = new StringBuilder(annotation.value()).toString();
		if (has(authority)) {
			return point.proceed();
		} else {
			throw new ForbiddenException();
		}
	}

	private boolean has(String authority) {
		// 用超管帐号方便测试，拥有所有权限
		HttpServletRequest request = ServletUtils.getRequest();
		AuthUser authUser =  tokenService.getLoginUser(request);
		if (ObjectUtil.isNotNull(authUser) && ObjectUtil.isNotNull(authUser.getUser())){
			Long userId = authUser.getUser().getUserId();
			if (userId == 1L) {
				return true;
			}
			Set<String> userPermsSet = sysMenuService.selectPermsByUserId(userId);
			return userPermsSet.stream().anyMatch(authority::equals);
		}
		return false;
	}
}
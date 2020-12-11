package com.qh.venus.achilles.sms.system.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.qh.venus.achilles.framework.aspectj.lang.annotation.LoginUser;
import com.qh.venus.achilles.framework.security.AuthUser;
import com.qh.venus.achilles.framework.security.service.TokenService;
import com.qh.venus.achilles.sms.system.domain.SysUser;
import com.qh.venus.achilles.sms.system.service.ISysUserService;

/**
 * @Title:有@LoginUser注解的方法参数，注入当前登录用户
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@Configuration
public class LoginUserHandlerResolver implements HandlerMethodArgumentResolver {
	@Autowired
	private ISysUserService userService;
	@Autowired
	private TokenService tokenService;
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType().isAssignableFrom(SysUser.class)
				&& parameter.hasParameterAnnotation(LoginUser.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
			NativeWebRequest nativeWebRequest, WebDataBinderFactory factory) throws Exception {
		HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
		// 获取用户ID
		AuthUser authUser=tokenService.getLoginUser(request);
		Long userid = Long.valueOf(authUser.getUser().getUserId());
		if (userid == null) {
			return null;
		}
		return userService.selectUserById(userid);
	}
}
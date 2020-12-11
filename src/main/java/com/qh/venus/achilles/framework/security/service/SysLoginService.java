package com.qh.venus.achilles.framework.security.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.qh.venus.achilles.common.utils.security.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.qh.venus.achilles.common.constant.Constants;
import com.qh.venus.achilles.common.exception.CustomException;
import com.qh.venus.achilles.common.exception.user.CaptchaException;
import com.qh.venus.achilles.common.exception.user.CaptchaExpireException;
import com.qh.venus.achilles.common.exception.user.UserPasswordNotMatchException;
import com.qh.venus.achilles.common.utils.MessageUtils;
import com.qh.venus.achilles.framework.manager.AsyncManager;
import com.qh.venus.achilles.framework.manager.factory.AsyncFactory;
import com.qh.venus.achilles.framework.redis.RedisCache;
import com.qh.venus.achilles.framework.redis.util.RedisUtils;
import com.qh.venus.achilles.framework.security.AuthUser;

/**
 * @Title: 登录校验方法
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@Component
public class SysLoginService {
	@Autowired
	private TokenService tokenService;

	@Resource
	private AuthenticationManager authenticationManager;

	@Autowired
	private RedisCache redisCache;

	@Autowired
	private RedisUtils redisUtils;
	/**
	 * 12小时后过期
	 */
	private final static long EXPIRE = 12 * 60 * 60;

	private final static String ACCESS_TOKEN = Constants.ACCESS_TOKEN;

	private final static String ACCESS_USERID = Constants.ACCESS_USERID;

	/**
	 * 登录验证
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param captcha
	 *            验证码
	 * @param uuid
	 *            唯一标识
	 * @return 结果
	 */
	public String login(String username, String password, String code, String uuid) {
		String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
		String captcha = redisCache.getCacheObject(verifyKey);
		redisCache.deleteObject(verifyKey);
		if (captcha == null) {
			AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
					MessageUtils.message("user.jcaptcha.expire")));
			throw new CaptchaExpireException();
		}
		if (!code.equalsIgnoreCase(captcha)) {
			AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
					MessageUtils.message("user.jcaptcha.error")));
			throw new CaptchaException();
		}
		// 用户验证
		Authentication authentication = null;
		try {
			// 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
			if (e instanceof BadCredentialsException) {
				AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
						MessageUtils.message("user.password.not.match")));
				throw new UserPasswordNotMatchException();
			} else {
				AsyncManager.me()
						.execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
				throw new CustomException(e.getMessage());
			}
		}
		AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS,
				MessageUtils.message("user.login.success")));
		AuthUser loginUser = (AuthUser) authentication.getPrincipal();
		// 生成token
		return tokenService.createToken(loginUser);
	}

	/**
	 * 登录验证
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param captcha
	 *            验证码
	 * @param uuid
	 *            唯一标识
	 * @return 结果
	 */
	public Map<String, Object> createToken(String username, String password, String code, String uuid) {
		String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
		String captcha = redisCache.getCacheObject(verifyKey);
		redisCache.deleteObject(verifyKey);
		if (captcha == null) {
			AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
					MessageUtils.message("user.jcaptcha.expire")));
			throw new CaptchaExpireException();
		}
		if (!code.equalsIgnoreCase(captcha)) {
			AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
					MessageUtils.message("user.jcaptcha.error")));
			throw new CaptchaException();
		}
		// 用户验证
		Authentication authentication = null;
		try {
			// 该方法会去调用UserDetailsServiceImpl.loadUserByUsername

			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
			if (e instanceof BadCredentialsException) {
				AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
						MessageUtils.message("user.password.not.match")));
				throw new UserPasswordNotMatchException();
			} else {
				AsyncManager.me()
						.execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
				throw new CustomException(e.getMessage());
			}
		}
		AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS,
				MessageUtils.message("user.login.success")));
		AuthUser loginUser = (AuthUser) authentication.getPrincipal();
		// 生成token
		String token = tokenService.createToken(loginUser);

		// 保存或更新用户token
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", loginUser.getUser().getUserId());
		map.put("token", token);
		map.put("expire", EXPIRE);
		redisUtils.set(ACCESS_TOKEN + token, loginUser.getUser(), EXPIRE);
		redisUtils.set(ACCESS_USERID + loginUser.getUser().getUserId(), token, EXPIRE);
		return map;
	}
}

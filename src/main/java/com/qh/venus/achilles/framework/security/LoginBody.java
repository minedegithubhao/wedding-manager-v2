package com.qh.venus.achilles.framework.security;

/**
 * @Title: 用户登录对象
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public class LoginBody {
	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 验证码
	 */
	private String code;

	/**
	 * 唯一标识
	 */
	private String uuid = "";

	/**
	 * 唯一标识
	 */
	private String randomStr;
	/**
	 * 验证码
	 */
	private String captcha;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getRandomStr() {
		return randomStr;
	}

	public void setRandomStr(String randomStr) {
		this.randomStr = randomStr;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	
}

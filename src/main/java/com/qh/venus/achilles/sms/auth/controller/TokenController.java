package com.qh.venus.achilles.sms.auth.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.venus.achilles.common.constant.Constants;
import com.qh.venus.achilles.framework.security.LoginBody;
import com.qh.venus.achilles.framework.security.service.SysLoginService;
import com.qh.venus.achilles.framework.web.domain.AjaxResult;
import com.qh.venus.achilles.framework.web.domain.R;

/**
 * @Title:Token管理
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
@RequestMapping("/auth")
public class TokenController {

	@Autowired
	private SysLoginService loginService;

	@PostMapping("login")
	public R login(@RequestBody LoginBody loginBody) {
		Map<String, Object> loginInfo = loginService.createToken(loginBody.getUsername(), loginBody.getPassword(),
				loginBody.getCaptcha(), loginBody.getRandomStr());
		return R.ok(loginInfo);
	}

}

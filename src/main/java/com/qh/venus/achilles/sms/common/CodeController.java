package com.qh.venus.achilles.sms.common;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Producer;
import com.qh.venus.achilles.common.constant.Constants;
import com.qh.venus.achilles.common.core.lang.UUID;
import com.qh.venus.achilles.framework.redis.RedisCache;
import com.qh.venus.achilles.framework.web.controller.BaseController;

/**
 * @Title:图片验证码（支持算术形式）
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
public class CodeController extends BaseController {
	@Resource(name = "captchaProducer")
	private Producer captchaProducer;

	@Resource(name = "captchaProducerMath")
	private Producer captchaProducerMath;

	@Autowired
	private RedisCache redisCache;

	/**
	 * 验证码生成
	 */
	@GetMapping(value = "/code")
	public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) {
		ServletOutputStream out = null;
		try {
			response.setDateHeader("Expires", 0);
			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			response.addHeader("Cache-Control", "post-check=0, pre-check=0");
			response.setHeader("Pragma", "no-cache");
			response.setContentType("image/jpeg");
			// 保存验证码信息
			String randomStr = UUID.randomUUID().toString().replaceAll("-", "");
			response.setHeader("randomstr", randomStr);

			String capStr = null;
			String code = null;
			BufferedImage bi = null;

			String capText = captchaProducerMath.createText();
			capStr = capText.substring(0, capText.lastIndexOf("@"));
			code = capText.substring(capText.lastIndexOf("@") + 1);
			bi = captchaProducerMath.createImage(capStr);
			redisCache.setCacheObject(Constants.CAPTCHA_CODE_KEY + randomStr, code, Constants.CAPTCHA_EXPIRATION,
					TimeUnit.MINUTES);
			out = response.getOutputStream();
			ImageIO.write(bi, "jpg", out);
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
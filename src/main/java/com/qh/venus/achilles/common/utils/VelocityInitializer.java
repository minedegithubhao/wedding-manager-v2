package com.qh.venus.achilles.common.utils;

import java.util.Properties;

import com.qh.venus.achilles.common.constant.Constants;
import org.apache.velocity.app.Velocity;

/**
 * @Title:VelocityEngine工厂
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public class VelocityInitializer {
	/**
	 * 初始化vm方法
	 */
	public static void initVelocity() {
		Properties p = new Properties();
		try {
			// 加载classpath目录下的vm文件
			p.setProperty("file.resource.loader.class",
					"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			// 定义字符集
			p.setProperty(Velocity.ENCODING_DEFAULT, Constants.UTF8);
			p.setProperty(Velocity.OUTPUT_ENCODING, Constants.UTF8);
			// 初始化Velocity引擎，指定配置Properties
			Velocity.init(p);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

package com.qh.venus.achilles.framework.redis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Title:redis缓存
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company 
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {
	/**
	 * 键名
	 * 
	 * @return
	 */
	String key() default "";

	/**
	 * 主键
	 * 
	 * @return
	 */
	String fieldKey();

	/**
	 * 过期时间
	 * 
	 * @return
	 */
	long expired() default 3600;

	/**
	 * 是否为查询操作 如果为写入数据库的操作，该值需置为 false
	 * 
	 * @return
	 */
	boolean read() default true;
}
package com.qh.venus.achilles.framework.config;

import java.util.TimeZone;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Title: 程序注解配置
 * @Description:
 * 表示通过aop框架暴露该代理对象,AopContext能够访问
 * 指定要扫描的Mapper类的包的路径
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */

@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.qh.venus.achilles.**.mapper")
public class ApplicationConfig
{
    /**
     * 时区配置
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization()
    {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
    }
}

package com.qh.venus.achilles.framework.log;
import com.qh.venus.achilles.framework.log.aspect.OperLogAspect;
import com.qh.venus.achilles.framework.log.listen.LogListener;
import com.qh.venus.achilles.sms.system.service.ISysLogininforService;
import com.qh.venus.achilles.sms.system.service.ISysOperLogService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Title:登出信息
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@EnableAsync
@Configuration
@ConditionalOnWebApplication
public class LogAutoConfiguration {
	@Autowired
	private ISysOperLogService sysOperLogService;
	@Autowired
	private ISysLogininforService sysLogininforService;
	@Bean
	public LogListener sysOperLogListener() {
		return new LogListener(sysOperLogService,sysLogininforService);
	}

	@Bean
	public OperLogAspect operLogAspect() {
		return new OperLogAspect();
	}
}
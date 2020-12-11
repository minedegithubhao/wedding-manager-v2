package com.qh.venus.achilles.framework.log.listen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import com.qh.venus.achilles.framework.log.event.SysLogininforEvent;
import com.qh.venus.achilles.framework.log.event.SysOperLogEvent;
import com.qh.venus.achilles.sms.system.domain.SysLogininfor;
import com.qh.venus.achilles.sms.system.domain.SysOperLog;
import com.qh.venus.achilles.sms.system.service.ISysLogininforService;
import com.qh.venus.achilles.sms.system.service.ISysOperLogService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title:异步监听日志事件
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@Slf4j
@AllArgsConstructor
public class LogListener {
	private ISysOperLogService sysOperLogService;
	private ISysLogininforService sysLogininforService;

	@Async
	@Order
	@EventListener(SysOperLogEvent.class)
	public void listenOperLog(SysOperLogEvent event) {
		SysOperLog sysOperLog = (SysOperLog) event.getSource();
		sysOperLogService.insertOperlog(sysOperLog);
		log.info("远程操作日志记录成功：{}", sysOperLog);
	}

	@Async
	@Order
	@EventListener(SysLogininforEvent.class)
	public void listenLoginifor(SysLogininforEvent event) {
		SysLogininfor sysLogininfor = (SysLogininfor) event.getSource();
		sysLogininforService.insertLogininfor(sysLogininfor);
		log.info("远程访问日志记录成功：{}", sysLogininfor);
	}
}
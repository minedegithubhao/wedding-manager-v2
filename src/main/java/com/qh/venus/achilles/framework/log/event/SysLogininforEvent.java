package com.qh.venus.achilles.framework.log.event;

import org.springframework.context.ApplicationEvent;

import com.qh.venus.achilles.sms.system.domain.SysLogininfor;


/**
 * @Title:系统日志事件
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public class SysLogininforEvent extends ApplicationEvent {
	private static final long serialVersionUID = -9084676463718966036L;

	public SysLogininforEvent(SysLogininfor source) {
		super(source);
	}
}
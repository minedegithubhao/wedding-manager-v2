package com.qh.venus.achilles.common.enums;

/**
 * @Title:用户会话
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public enum OnlineStatus {
	/** 用户状态 */
	on_line("在线"), off_line("离线");

	private final String info;

	private OnlineStatus(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
}

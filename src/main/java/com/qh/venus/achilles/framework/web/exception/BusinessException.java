package com.qh.venus.achilles.framework.web.exception;

/**
 * @Title:业务异常
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	protected final String message;

	public BusinessException(String message) {
		this.message = message;
	}

	public BusinessException(String message, Throwable e) {
		super(message, e);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}

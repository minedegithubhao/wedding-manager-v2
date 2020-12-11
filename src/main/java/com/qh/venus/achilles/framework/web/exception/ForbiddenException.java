package com.qh.venus.achilles.framework.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Title:权限不足
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "forbidden")
public class ForbiddenException extends RuntimeException {
	private static final long serialVersionUID = -4552488542483342775L;

	private static final String DEFAULT_MSG = "forbidden";

	public ForbiddenException(String msg) {
		super(msg);
	}

	public ForbiddenException() {
		super(DEFAULT_MSG);
	}
}

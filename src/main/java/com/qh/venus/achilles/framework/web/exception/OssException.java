package com.qh.venus.achilles.framework.web.exception;

/**
 * @Title:OSS信息异常类
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public class OssException extends RuntimeException
{
    private static final long serialVersionUID = 2146840966262730160L;

    public OssException(String msg)
    {
        super(msg);
    }
}
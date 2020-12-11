package com.qh.venus.achilles.common.exception.script;

/**
 * @Title:计划策略异常
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public class ScriptException extends Exception
{
    private static final long serialVersionUID = 1L;

    private Code code;

    public ScriptException(String msg, Code code)
    {
        this(msg, code, null);
    }

    public ScriptException(String msg, Code code, Exception nestedEx)
    {
        super(msg, nestedEx);
        this.code = code;
    }

    public Code getCode()
    {
        return code;
    }

    public enum Code
    {
        TASK_EXISTS, NO_TASK_EXISTS, TASK_ALREADY_STARTED, UNKNOWN, CONFIG_ERROR, TASK_NODE_NOT_AVAILABLE
    }
}
package com.qh.venus.achilles.framework.api.exception;

public class DbConnectionFailException extends RuntimeException{
    public DbConnectionFailException(String message,Throwable throwable) {
        super(message,throwable);
    }
}

package com.qh.venus.achilles.framework.api.exception;

public class EvidenceFailException extends RuntimeException{
    public EvidenceFailException(String message, Throwable throwable) {
        super(message,throwable);
    }
}

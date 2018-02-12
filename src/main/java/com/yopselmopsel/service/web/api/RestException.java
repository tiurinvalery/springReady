package com.yopselmopsel.service.web.api;

public class RestException extends Exception {
    public RestException() {

    }

    public RestException(String message) {
        super(message);
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestException(Throwable cause) {
        super(cause);
    }

    public RestException(String message, Throwable cause, boolean enableSuppersession, boolean writableStackTrace) {
        super(message, cause, enableSuppersession,writableStackTrace);
    }
}

package com.scorpion.risk.exception;

/**
 * Created on 2017/9/16.
 */
public class RequestLimitException extends Exception {
    public RequestLimitException() {
        super("HTTP请求超出设定限制");
    }

    public RequestLimitException(String message) {
        super(message);
    }
}

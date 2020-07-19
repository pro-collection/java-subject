package com.yanle.mybatis.plus.demo1.system.config.exception;

import javax.naming.AuthenticationException;

public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String message) {
        super(message);
    }
}

package com.yanle.mybatis.plus.demo1.system.config.exception;

import lombok.Data;

/**
 * 业务异常
 */
@Data
public class BusinessInterfaceException extends RuntimeException {
    public BusinessInterfaceException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessInterfaceException(String message) {
        this.message = message;
    }

    private String code;
    private String message;
}

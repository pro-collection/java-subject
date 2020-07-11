package com.yanle.mybatis.plus.demo1.common.base;

public enum Status {
    SUCCESS(200, "ok"),
    INTERNAL_SERVER_ERROR(500, "Unknown Internal Error");

    private int code;
    private String standardMessage;

    Status(int code, String standardMessage) {
        this.code = code;
        this.standardMessage = standardMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStandardMessage() {
        return standardMessage;
    }

    public void setStandardMessage(String standardMessage) {
        this.standardMessage = standardMessage;
    }
}

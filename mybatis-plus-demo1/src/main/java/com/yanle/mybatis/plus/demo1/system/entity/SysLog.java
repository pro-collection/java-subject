package com.yanle.mybatis.plus.demo1.system.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class SysLog implements Serializable {

    private static final long serialVersionUID = -7922160992156093434L;

    private String id;
    private String username;
    private String ipAddress;
    private String ipSource;
    private String message;
    private String browserName;
    private String systemName;
    private Date createDate;
}

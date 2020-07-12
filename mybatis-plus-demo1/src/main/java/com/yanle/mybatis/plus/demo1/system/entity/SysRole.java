package com.yanle.mybatis.plus.demo1.system.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class SysRole implements Serializable {

    private static final long serialVersionUID = -4389469336005052688L;

    private String id;
    private String authority;
    private String name;
    private Date createTime;

    public SysRole() {
    }

    public SysRole(String id, String authority, String name, Date createTime) {
        this.id = id;
        this.authority = authority;
        this.name = name;
        this.createTime = createTime;
    }
}

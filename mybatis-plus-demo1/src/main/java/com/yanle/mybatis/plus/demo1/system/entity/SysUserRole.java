package com.yanle.mybatis.plus.demo1.system.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SysUserRole {
    private String userId;
    private String roleId;

    public SysUserRole() {
    }

    public SysUserRole(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}

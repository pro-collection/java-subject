package com.yanle.mybatis.plus.demo1.system.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SysMenuRole {
    private String menuId;
    private String roleId;

    public SysMenuRole(String menuId, String roleId) {
        this.menuId = menuId;
        this.roleId = roleId;
    }

    public SysMenuRole(String menuId) {
        this.menuId = menuId;
    }
}

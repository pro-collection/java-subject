package com.yanle.mybatis.plus.demo1.system.vo;

import com.yanle.mybatis.plus.demo1.system.entity.SysRole;
import lombok.Data;

@Data
public class RoleVO extends SysRole {
    private String[] ids;
}

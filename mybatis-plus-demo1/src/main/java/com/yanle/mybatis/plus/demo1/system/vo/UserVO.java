package com.yanle.mybatis.plus.demo1.system.vo;

import com.yanle.mybatis.plus.demo1.system.entity.SysUser;
import lombok.Data;

@Data
public class UserVO extends SysUser {
    private String userRole;

    public UserVO() {
    }

    public UserVO(String userRole) {
        this.userRole = userRole;
    }
}

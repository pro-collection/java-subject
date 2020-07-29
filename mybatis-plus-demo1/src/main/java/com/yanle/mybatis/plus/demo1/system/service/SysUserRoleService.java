package com.yanle.mybatis.plus.demo1.system.service;

import com.yanle.mybatis.plus.demo1.system.entity.SysUserRole;

public interface SysUserRoleService {

    /**
     * 添加用户和角色的联系
     * @param sysUserRole 用户角色
     * @return 返回值
     */
    int insert(SysUserRole sysUserRole);

    /**
     * 根据用户id删除用户和角色的联系
     * @param userId 用户id
     * @return 返回值
     */
    int deleteByUserId(String userId);
}

package com.yanle.mybatis.plus.demo1.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.system.entity.SysRole;
import org.apache.ibatis.annotations.Param;

public interface SysRoleService {
    /**
     * 根据 ID 查询角色
     * @param userId id
     * @return SysRole
     */
    SysRole findByUserId(@Param("userId") String userId);

    /**
     * 查询所有角色
     * @param page page
     * @return 角色集合
     */
    IPage<SysRole> getAll(Page page);

    /**
     * 根据名称查询角色
     * @param name name
     * @return SysRole
     */
    SysRole getByName(String name);

    /**
     * 根据id查询角色名称
     * @param id id
     * @return 角色明湖曾
     */
    String getRoleNameById(String id);

    /**
     * 根据 Id 删除角色
     * @param id id
     * @return 返回值
     */
    int deleteById(String id);


}

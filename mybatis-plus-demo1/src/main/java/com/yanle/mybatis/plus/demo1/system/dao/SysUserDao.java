package com.yanle.mybatis.plus.demo1.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.system.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao extends BaseMapper<SysUser> {
    /**
     * 根据用户信命查询
     * @param name name
     * @return sysUser
     */
    @Select("select * from sys_user where name = #{name}")
    SysUser findByName(@Param("name") String name);

    /**
     * 查询所有用户
     * @param page 分页数据
     * @return 分页集合
     */
    @Select("select * from sys_user")
    IPage<SysUser> getAll(Page page);

    /**
     * 根据 Id 查询用户
     * @param id id
     * @return SySUser
     */
    @Select("select * from sys_user where id = #{id}")
    SysUser getById(@Param("id") String id);

    /**
     * 更改用户密码
     * @param password 密码
     * @param id id
     * @return 更改结果
     */
    @Select("update sys_user set password = #{password} where id = #{id}")
    int updatePasswordById(@Param("password") String password, @Param("id") String id);
}

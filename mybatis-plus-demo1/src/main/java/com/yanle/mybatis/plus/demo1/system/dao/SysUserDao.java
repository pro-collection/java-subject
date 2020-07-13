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
}

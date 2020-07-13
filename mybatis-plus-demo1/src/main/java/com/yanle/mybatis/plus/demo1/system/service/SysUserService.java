package com.yanle.mybatis.plus.demo1.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yanle.mybatis.plus.demo1.system.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import sun.jvm.hotspot.debugger.Page;

public interface SysUserService {

    /**
     * 根据姓名查询
     * @param name 姓名
     * @return 用户
     */
    SysUser findByName(@Param("name") String name);

    /**
     * 查询所有用户
     * @param page 分页数据
     * @return 所有用户集合
     */
    IPage<SysUser> getAll(Page page);

    /**
     * 根据id查用户
     * @param id id
     * @return 用
     */
    SysUser getById(String id);

    /**
     * 根据id删除用户
     * @param id id
     * @return 返回值
     */
    int deleteById(String id);

    /**
     * 保存用户
     * @param sysUser 用户
     * @return 返回值
     */
    int updateById(SysUser sysUser);

    /**
     * 保存用户
     * @param sysUser 用户
     * @return return
     */
    int insert(SysUser sysUser);

    /**
     * 根据用户ID ， 更新密码
     * @param password 密码
     * @param id id
     * @return return
     */
    int updatePasswordById(String password, String id);
}

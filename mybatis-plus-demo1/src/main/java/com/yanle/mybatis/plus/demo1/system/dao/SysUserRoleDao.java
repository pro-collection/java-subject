package com.yanle.mybatis.plus.demo1.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanle.mybatis.plus.demo1.system.entity.SysUserRole;
import org.apache.ibatis.annotations.Delete;

public interface SysUserRoleDao extends BaseMapper<SysUserRole> {
    /**
     * 根据用户id删除用户和角色的联系
     * @param userId 用户id
     * @return 返回值
     */
    @Delete("delete from sys_user_role where user_id = #{userId}")
    int deleteByUserId(String userId);
}

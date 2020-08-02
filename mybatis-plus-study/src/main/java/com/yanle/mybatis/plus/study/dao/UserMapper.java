package com.yanle.mybatis.plus.study.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.study.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> selectAll(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    IPage<User> selectUserPage(Page<User> page, @Param(Constants.WRAPPER) Wrapper<User> wrapper);

    /**
     * 如果是自定义的查询， 会丢失 逻辑删除的功能
     *
     * 解决办法有两个
     * 1、在 userMapper 调用的时候， 自己在查询的条件写上限定
     * 2、自己在自定义sql语句的时候， 加上限定
     * @param wrapper wrapper
     * @return 用户List
     */
    @Select("select * from user ${ew.customSqlSegment}")
    List<User> mySelectList(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    /**
     * 删除所有
     * @return 影响行数
     */
    Integer deleteAll();
}

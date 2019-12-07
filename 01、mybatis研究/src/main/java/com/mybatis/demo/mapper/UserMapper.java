package com.mybatis.demo.mapper;

import com.mybatis.demo.entity.User;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    public User queryUserById(String id);

    /**
     * 查询全部
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 新增用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 根据ID 删除用户
     * @param id
     */
    public void deleteUser(String id);
}

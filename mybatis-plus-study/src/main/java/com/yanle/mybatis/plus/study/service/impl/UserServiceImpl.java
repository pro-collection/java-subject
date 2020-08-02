package com.yanle.mybatis.plus.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanle.mybatis.plus.study.dao.UserMapper;
import com.yanle.mybatis.plus.study.entity.User;
import com.yanle.mybatis.plus.study.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

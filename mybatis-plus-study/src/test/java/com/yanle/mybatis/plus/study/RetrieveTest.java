package com.yanle.mybatis.plus.study;

import com.yanle.mybatis.plus.study.dao.UserMapper;
import com.yanle.mybatis.plus.study.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * 查询
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RetrieveTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectById() {
        User user = userMapper.selectById(1094592041087729666L);
        System.out.println(user);
    }

    @Test
    public void batchSelectById() {
        List<Long> ids = Arrays.asList(1087982257332887553L, 1088248166370832385L, 1088250446457389058L);
        List<User> userList = userMapper.selectBatchIds(ids);
        Assert.assertEquals(3, userList.size());
        userList.forEach(item -> System.out.println(item));
    }
}
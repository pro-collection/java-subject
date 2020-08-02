package com.yanle.mybatis.plus.study;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yanle.mybatis.plus.study.dao.UserMapper;
import com.yanle.mybatis.plus.study.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InjectorTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 逻辑删除
     */
    @Test
    public void deleteAll() {
        int rows = userMapper.deleteAll();
        System.out.println("影响行数： " + rows);
    }
}

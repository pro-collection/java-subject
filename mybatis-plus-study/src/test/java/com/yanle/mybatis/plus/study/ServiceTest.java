package com.yanle.mybatis.plus.study;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yanle.mybatis.plus.study.entity.User;
import com.yanle.mybatis.plus.study.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getOneTest() {
        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        // 如果查询结果是多个， 但是没有第二个参数 false, 那么是会报错的。
        User one = userService.getOne(lambda.gt(User::getAge, 25), false);
        System.out.println(one);
    }
}

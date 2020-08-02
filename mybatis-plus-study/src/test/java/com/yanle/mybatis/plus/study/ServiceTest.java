package com.yanle.mybatis.plus.study;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yanle.mybatis.plus.study.entity.User;
import com.yanle.mybatis.plus.study.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 查询一个内容
     */
    @Test
    public void getOneTest() {
        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        // 如果查询结果是多个， 但是没有第二个参数 false, 那么是会报错的。
        User one = userService.getOne(lambda.gt(User::getAge, 25), false);
        System.out.println(one);
    }

    /**
     * 批量修改插入
     */
    @Test
    public void Batch() {
        User user1 = new User();
        user1.setName("张毅");
        user1.setAge(28);

        User user2 = new User();
        user2.setName("张毅2");
        user2.setAge(28);

        List<User> userList = Arrays.asList(user1, user2);
        boolean saveBatch = userService.saveBatch(userList);
        System.out.println("saveBatch ： " + saveBatch);
    }

    /**
     * 批量修改插入
     */
    @Test
    public void BatchSaveOrUpdate() {
        User user1 = new User();
        user1.setName("张毅");
        user1.setAge(28);

        User user2 = new User();
        user2.setId(1289805833621561346L);
        user2.setName("张毅张毅张毅张毅2");
        user2.setAge(28);

        List<User> userList = Arrays.asList(user1, user2);
        boolean saveBatch = userService.saveOrUpdateBatch(userList);
        System.out.println("saveBatch ： " + saveBatch);
    }

    /**
     * 链式调用
     */
    @Test
    public void chain() {
        List<User> userList = userService.lambdaQuery().gt(User::getAge, 25).like(User::getName, "雨").list();
        userList.forEach(System.out::println);
    }

    /**
     * 链式调用
     */
    @Test
    public void chain2() {
        boolean update = userService.lambdaUpdate().eq(User::getAge, 25).set(User::getAge, 26).update();
        System.out.println("update: " + update);
    }
}

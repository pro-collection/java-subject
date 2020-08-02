package com.yanle.mybatis.plus.study;

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
public class MyTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 逻辑删除
     */
    @Test
    public void deleteById() {
        int rows = userMapper.deleteById(1094590409767661570L);
        System.out.println("影响行数： " + rows);
    }

    /**
     * 查找逻辑
     * 里面没有我们逻辑删除的内容
     */
    @Test
    public void select() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    /**
     * 只能更新逻辑未删除的
     */
    @Test
    public void updateById() {
        User user = new User();
        user.setAge(26);
        user.setId(1088248166370832385L);
        int rows = userMapper.updateById(user);
        System.out.println("rows: " + rows);
    }
}

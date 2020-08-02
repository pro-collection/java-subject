package com.yanle.mybatis.plus.study;

import com.yanle.mybatis.plus.study.dao.UserMapper;
import com.yanle.mybatis.plus.study.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 乐观锁
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OptTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 插入数据， 这个时候，会自定填充 create_time
     */
    @Test
    public void insert() {
        User user = new User();
        user.setName("刘翔");
        user.setAge(21);
        user.setEmail("lx@163.com");
        user.setManagerId(1088248166370832385L);
        int rows = userMapper.insert(user);
        System.out.println("影响行数： " + rows);
    }

    /**
     * 更新， 会自动更新 update_time
     */
    @Test
    public void updateById() {
        int version = 1;
        User user = new User();
        user.setEmail("balabala@163.com");
        user.setId(1289913559076925442L);
        user.setVersion(version);
        int rows = userMapper.updateById(user);
        System.out.println("rows: " + rows);
    }
}

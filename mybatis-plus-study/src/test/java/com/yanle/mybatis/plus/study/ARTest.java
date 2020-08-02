package com.yanle.mybatis.plus.study;

import com.yanle.mybatis.plus.study.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ARTest {

    /**
     * 插入方法
     */
    @Test
    public void insertTest() {
        User user = new User();
        user.setName("长草");
        user.setAge(24);
        user.setEmail("zc@123kjsdk.com");
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(LocalDateTime.now());
        boolean insert = user.insert();
        System.out.println("insert: " + insert);
    }

    /**
     * 选择
     */
    @Test
    public void selectById1() {
        User user = new User();
        User userSelect = user.selectById(1289793409472389122L);
        // 返回的是一个新对象
        System.out.println(userSelect);
    }

    /**
     * 选择
     */
    @Test
    public void selectById2() {
        User user = new User();
        user.setId(1289793409472389122L);
        User userSelect = user.selectById();
        // 返回的是一个新对象
        System.out.println(userSelect);
    }


    /**
     * 修改
     */
    @Test
    public void updateById() {
        User user = new User();
        user.setId(1289793409472389122L);
        user.setName("张草草");
        boolean updateSelect = user.updateById();
        // 返回的是一个新对象
        System.out.println("updateSelect: " + updateSelect);
    }

    /**
     * 删除
     */
    @Test
    public void deleteById() {
        User user = new User();
        user.setId(1289793409472389122L);
        boolean deleteSelect = user.deleteById();
        // 返回的是一个新对象
        System.out.println("deleteSelect: " + deleteSelect);
    }

    /**
     * insertOrUpdate
     */
    @Test
    public void insertOrUpdate() {
        User user = new User();
        user.setId(1289796684967907329L);
        user.setName("张三娃");
        user.setAge(24);
        user.setEmail("zc234234234@123kjsdk.com");
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(LocalDateTime.now());
        boolean insertOrUpdate = user.insertOrUpdate();
        System.out.println("insertOrUpdate: " + insertOrUpdate);
    }
}

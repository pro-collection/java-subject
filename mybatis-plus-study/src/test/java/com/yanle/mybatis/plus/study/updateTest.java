package com.yanle.mybatis.plus.study;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.yanle.mybatis.plus.study.dao.UserMapper;
import com.yanle.mybatis.plus.study.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class updateTest {
    @Autowired
    private UserMapper userMapper;

    /*
    通过 ID 更新
    * */
    @Test
    public void updateByIds() {
        User user = new User();
        user.setId(1288629505056681985L);
        user.setAge(26);
        user.setEmail("sifu2or1@sd.com");
        int updateCount = userMapper.updateById(user);
        System.out.println("updateCount: " + updateCount);
    }

    /**
     * 通过 updateWrapper 更新
     */
    @Test
    public void updateByWrapper() {
        UpdateWrapper<User> updateByWrapper = new UpdateWrapper<>();
        updateByWrapper.eq("name", "小胡");
        User user = new User();
        user.setEmail("sifuio1@11.com");
        user.setAge(29);
        int updateRows = userMapper.update(user, updateByWrapper);
        System.out.println(updateRows);
    }

    /**
     * 条件构造器
     */
    @Test
    public void updateByWrapper2() {
        User whereUser = new User();
        whereUser.setName("小胡");
        UpdateWrapper<User> updateByWrapper = new UpdateWrapper<>(whereUser);
        User user = new User();
        user.setEmail("小胡@11.com");
        user.setAge(29);
        int updateRows = userMapper.update(user, updateByWrapper);
        System.out.println("updateRows： " + updateRows);
    }

    /**
     * 只更改少量字段的场景
     */
    @Test
    public void updateByWrapper3() {
        UpdateWrapper<User> updateByWrapper = new UpdateWrapper<>();
        updateByWrapper.eq("name", "小胡").set("age", 30);
        int updateRows = userMapper.update(null, updateByWrapper);
        System.out.println("updateRows： " + updateRows);
    }

    /**
     * lambda使用场景
     */
    @Test
    public void updateByWrapperLambda() {
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(User::getName, "小胡").set(User::getAge, 31);
        int updateRows = userMapper.update(null, lambdaUpdateWrapper);
        System.out.println("updateRows： " + updateRows);
    }

    /**
     * lambda使用场景 - chain
     */
    @Test
    public void updateByWrapperLambdaChain() {
        boolean updateResult = new LambdaUpdateChainWrapper<User>(userMapper)
                .eq(User::getName, "小胡").set(User::getAge, 32).update();
        System.out.println("updateResult： " + updateResult);
    }
}

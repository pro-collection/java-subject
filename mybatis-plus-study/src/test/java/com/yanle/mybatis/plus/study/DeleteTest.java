package com.yanle.mybatis.plus.study;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.yanle.mybatis.plus.study.dao.UserMapper;
import com.yanle.mybatis.plus.study.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据 id 删除
     */
    @Test
    public void deleteById() {
        int rows = userMapper.deleteById(1288629505056681985L);
        System.out.println("rows: " + rows);
    }

    /**
     * 根据 map 删除
     */
    @Test
    public void deleteByMap() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", "向后");
        columnMap.put("age", 25);
        int rows = userMapper.deleteByMap(columnMap);
        System.out.println("rows: " + rows);
    }

    /**
     * 批量删除
     */
    @Test
    public void deleteByBatchIds() {
        int rows = userMapper.deleteBatchIds(Arrays.asList(12L, 13L, 14L));
        System.out.println("rows: " + rows);
    }

    /**
     * lambda 方式删除
     */
    @Test
    public void deleteByWrapper() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getAge, 27).or().gt(User::getAge, 41);
        int rows = userMapper.delete(lambdaQueryWrapper);
        System.out.println("删除条数： " + rows);
    }
}

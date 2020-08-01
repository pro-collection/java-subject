package com.yanle.mybatis.plus.study;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.yanle.mybatis.plus.study.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}

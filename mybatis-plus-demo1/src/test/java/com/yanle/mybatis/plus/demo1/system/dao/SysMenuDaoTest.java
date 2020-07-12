package com.yanle.mybatis.plus.demo1.system.dao;

import com.yanle.mybatis.plus.demo1.system.entity.SysMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysMenuDaoTest {

    @Autowired
    private SysMenuDao sysMenuDao;

    @Test
    public void TestGetFirstMenu() {
        System.out.println(("----- selectAll method test ------"));
        List<SysMenu> sysMenuList = sysMenuDao.getFirstMenu();
        sysMenuList.forEach(System.out::println);
    }
}
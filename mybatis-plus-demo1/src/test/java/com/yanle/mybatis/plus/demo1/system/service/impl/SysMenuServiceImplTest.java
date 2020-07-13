package com.yanle.mybatis.plus.demo1.system.service.impl;

import com.yanle.mybatis.plus.demo1.system.service.SysMenuService;
import com.yanle.mybatis.plus.demo1.system.vo.MenuVo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SysMenuServiceImplTest {
    @Autowired
    private SysMenuService sysMenuService;

    @Test
    void getMenuByUser() {
        List<MenuVo> menuVoList = sysMenuService.getMenuByUser("admin");
        if (menuVoList != null) {
            System.out.println("-------------");
            menuVoList.forEach(System.out::println);
            System.out.println(menuVoList.size());
            System.out.println("-------------");
        }
    }

    @Test
    void findMenuListByUser() {
    }

    @Test
    void findFirstMenu() {
    }

    @Test
    void findByParentId() {
    }

    @Test
    void updateMenu() {
    }

    @Test
    void addMenu() {
    }

    @Test
    void getByName() {
    }

    @Test
    void getById() {
    }

    @Test
    void getFirstMenu() {
    }

    @Test
    void getSecondMenu() {
    }

    @Test
    void getRoleMenu() {
    }

    @Test
    void getMenuLevel() {
    }

    @Test
    void getPreviousMenu() {
    }

    @Test
    void getByMenuName() {
    }

    @Test
    void deleteMenuById() {
    }
}
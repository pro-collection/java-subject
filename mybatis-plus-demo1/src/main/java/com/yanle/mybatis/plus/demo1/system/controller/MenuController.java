package com.yanle.mybatis.plus.demo1.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/menu")
public class MenuController {

    @GetMapping("/list")
    public String index() {
        return "module/menu/menu";
    }

    @GetMapping("/add")
    public String add() {
        return "module/menu/addMenu";
    }

    @GetMapping("/update")
    public String update() {
        // todo 通过 id 获取 sysMenu 信息
        return "module/menu/updateMenu";
    }

}

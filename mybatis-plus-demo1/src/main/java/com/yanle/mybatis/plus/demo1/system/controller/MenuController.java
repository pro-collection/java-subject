package com.yanle.mybatis.plus.demo1.system.controller;

import com.yanle.mybatis.plus.demo1.system.entity.SysMenu;
import com.yanle.mybatis.plus.demo1.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/menu")
public class MenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/list")
    public String index() {
        return "module/menu/menu";
    }

    @GetMapping("/add")
    public String add() {
        return "module/menu/addMenu";
    }

    @GetMapping("/update")
    public String update(String id, Model model) {
        SysMenu sysMenu = sysMenuService.getById(id);
        model.addAttribute("sysMenu", sysMenu);
        return "module/menu/updateMenu";
    }
}

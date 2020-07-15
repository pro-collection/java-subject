package com.yanle.mybatis.plus.demo1.system.controller;

import com.yanle.mybatis.plus.demo1.system.entity.SysUser;
import com.yanle.mybatis.plus.demo1.system.service.SysRoleService;
import com.yanle.mybatis.plus.demo1.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web/user")
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/list")
    public String list() {
        return "module/user/user";
    }

    @GetMapping("/update")
    public String update(String id, Model model) {
        SysUser sysUser = sysUserService.getById(id);
        String roleName = sysRoleService.getRoleNameById(sysUser.getId());
        model.addAttribute("sysUser", sysUser);
        model.addAttribute("roleName", roleName);
        return "module/user/updateUser";
    }

    @GetMapping("/add")
    public String add() {
        return "module/user/addUser";
    }

    @GetMapping("/changePassword")
    public String changePassword() {
        return "module/user/changePassword";
    }
}

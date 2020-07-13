package com.yanle.mybatis.plus.demo1.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/sys_log")
public class SysLogController {
    @GetMapping("/list")
    public String list() {
        return "module/syslog/syslog";
    }
}

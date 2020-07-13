package com.yanle.mybatis.plus.demo1.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/system")
public class SystemInfoController {
    @GetMapping("/serverInfo")
    public String serverInfo() {
        return "module/system/server";
    }

    @GetMapping("/introduce")
    public String introduce() {
        return "module/system/introduce";
    }
}

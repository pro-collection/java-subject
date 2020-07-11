package com.yanle.mybatis.plus.demo1.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }
}

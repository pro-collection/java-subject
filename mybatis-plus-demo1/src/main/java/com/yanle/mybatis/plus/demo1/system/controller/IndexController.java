package com.yanle.mybatis.plus.demo1.system.controller;

import com.yanle.mybatis.plus.demo1.common.base.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class IndexController {

    @RequestMapping("")
    public String home() {
        return "home";
    }

    @RequestMapping("*")
    public String redirect() {
        return "home";
    }
}

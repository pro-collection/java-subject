package com.yanle.mybatis.plus.demo1.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/devUtils")
public class DevUtilsController {

    @GetMapping("/menuIcon")
    public String menuIcon() {
        return "module/devutils/menuIcon";
    }

    @GetMapping("/vCharts")
    public String vcharts() {
        return "module/devutils/vCharts";
    }
}

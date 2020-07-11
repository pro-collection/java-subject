package com.yanle.mybatis.plus.demo1.system.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.yanle.mybatis.plus.demo1.common.base.Constants;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ErrorPageController implements ErrorController {
    private static final String ERROR_PATH = "/error";

    @RequestMapping("/error")
    public String error(HttpServletResponse response) {
        if (Constants.INT_PAGE_ERROR == response.getStatus()) return Constants.STRING_PAGE_ERROR;
        return Constants.STRING_PAGE_NOT_FOUND;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}

package com.yanle.mybatis.plus.demo1.common.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }
}

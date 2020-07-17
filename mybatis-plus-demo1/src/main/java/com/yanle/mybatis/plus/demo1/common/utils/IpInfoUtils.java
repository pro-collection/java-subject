package com.yanle.mybatis.plus.demo1.common.utils;

import javax.servlet.http.HttpServletRequest;

public class IpInfoUtils {

    /**
     * 获取ip
     *
     * @param request request
     * @return ip
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("Proxy-Client-IP");
        // todo
        return "";
    }
}

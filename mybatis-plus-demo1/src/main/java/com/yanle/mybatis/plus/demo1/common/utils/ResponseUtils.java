package com.yanle.mybatis.plus.demo1.common.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtils {
    public static void print(HttpServletResponse response, Object... objects) throws IOException, ServletException {
        PrintWriter writer = utf8AndJson(response).getWriter();
        for (Object o : objects) {
            writer.print(o);
        }
        writer.flush();
        writer.close();
    }

    private static HttpServletResponse utf8AndJson(HttpServletResponse response) {
        response.setContentType("text/json;charset=utf-8");
        return response;
    }
}

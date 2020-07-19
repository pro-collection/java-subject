package com.yanle.mybatis.plus.demo1.system.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomInvalidSessionStrategy implements InvalidSessionStrategy {

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Override
    public void onInvalidSessionDetected(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        httpServletRequest.getRequestDispatcher("/invalid_session").forward(httpServletRequest, httpServletResponse);
    }
}

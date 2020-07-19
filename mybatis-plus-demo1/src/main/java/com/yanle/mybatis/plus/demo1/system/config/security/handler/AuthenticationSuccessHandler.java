package com.yanle.mybatis.plus.demo1.system.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.yanle.mybatis.plus.demo1.common.base.ApiResponse;
import com.yanle.mybatis.plus.demo1.common.base.Constants;
import com.yanle.mybatis.plus.demo1.common.utils.RequestUtils;
import com.yanle.mybatis.plus.demo1.common.utils.ResponseUtils;
import com.yanle.mybatis.plus.demo1.system.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private SysLogService sysLogService;

    private static final String LOGIN_SUCCESS = JSON.toJSONString(ApiResponse.success(Constants.LOGIN_SUCCESS));

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (RequestUtils.isAjax(request)) {
            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
            String name = token.getName();
            // 保存日志
            sysLogService.saveLoginLog(request, Constants.LOGIN_SUCCESS, name);
            ResponseUtils.print(response, LOGIN_SUCCESS);
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}

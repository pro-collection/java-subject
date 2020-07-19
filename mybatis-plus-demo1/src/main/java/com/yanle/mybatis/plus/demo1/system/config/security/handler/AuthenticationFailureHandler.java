package com.yanle.mybatis.plus.demo1.system.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.yanle.mybatis.plus.demo1.common.base.ApiResponse;
import com.yanle.mybatis.plus.demo1.common.base.Constants;
import com.yanle.mybatis.plus.demo1.common.utils.RequestUtils;
import com.yanle.mybatis.plus.demo1.common.utils.ResponseUtils;
import com.yanle.mybatis.plus.demo1.system.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private SysLogService sysLogService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (RequestUtils.isAjax(request)) {
            String username = request.getParameter("username");
            String message;

            // todo 总感觉有问题
            if (exception instanceof SessionAuthenticationException) {
                message = Constants.LOGIN_MAX_LIMIT;
                // 目的就是写入response
                ResponseUtils.print(response, JSON.toJSONString(ApiResponse.fail(message)));
            }
            message = exception.getMessage();
            sysLogService.saveLoginLog(request, message, username);
            ResponseUtils.print(response, JSON.toJSONString(ApiResponse.fail(message)));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}

package com.yanle.mybatis.plus.demo1.system.config.interceptor;

import com.yanle.mybatis.plus.demo1.common.utils.SecurityUtils;
import com.yanle.mybatis.plus.demo1.system.entity.SysMenu;
import com.yanle.mybatis.plus.demo1.system.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class AccessAuthHandlerInterceptor implements HandlerInterceptor {
    private String contextPath = null;

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<SysMenu> secondMenu = sysMenuService.getSecondMenu();
        List<String> urlList = secondMenu.stream().map(SysMenu::getMenuHref).collect(Collectors.toList());
        String servletPath = StringUtils.replace(request.getServletPath(), "/", "", 1);
        if (urlList.contains(servletPath)) {
            String username = (String) SecurityUtils.getCurrentUserAuthentication().getPrincipal();
            List<SysMenu> sysMenuList = sysMenuService.findMenuListByUser(username);
            if (sysMenuList.stream().anyMatch(item -> servletPath.equals(item.getMenuHref())))
                return true;
            response.sendRedirect(contextPath + "/403");
            return false;
        }
        return true;
    }
}

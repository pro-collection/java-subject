package com.yanle.mybatis.plus.demo1.system.config.xss;

import com.yanle.mybatis.plus.demo1.system.config.filter.XssFilter;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    HttpServletRequest orgRequest = null;

    private boolean isIncludeRichText = false;

    public XssHttpServletRequestWrapper(HttpServletRequest request, boolean isIncludeRichText) {
        super(request);
        orgRequest = request;
        this.isIncludeRichText = isIncludeRichText;
    }

    /**
     * 覆盖getParameter方法，将参数名和参数值都做xss过滤.
     * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取
     * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
     */
    @Override
    public String getParameter(String name) {
        boolean condition = ("content".equals(name) || name.endsWith("WithHtml")) && !isIncludeRichText;
        if (condition) return super.getParameter(name);
        name = XssFilterUtil.clean(name);
        String value = super。getParameter(name);
        if (StringUtils.isNotBlank(value)) value = XssFilterUtil.clean(value);
        return value;
    }
}

package com.yanle.mybatis.plus.demo1.system.config.xss;

import org.jsoup.safety.Whitelist;

public class XssFilterUtil {
    /**
     * 使用自带的basicWithImages 白名单
     * 允许的便签有a,b,blockquote,br,cite,code,dd,dl,dt,em,i,li,ol,p,pre,q,small,span,
     * strike,strong,sub,sup,u,ul,img
     * 以及a标签的href,img标签的src,align,alt,height,width,title属性
     */

    private static final Whitelist WHITELIST = Whitelist.basicWithImages();
}

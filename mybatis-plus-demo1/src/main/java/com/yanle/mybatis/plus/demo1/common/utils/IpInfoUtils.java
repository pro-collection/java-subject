package com.yanle.mybatis.plus.demo1.common.utils;

import cn.hutool.core.io.resource.ClassPathResource;
import com.yanle.mybatis.plus.demo1.common.base.Constants;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.UserAgent;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpInfoUtils {

    /**
     * 获取客户端ip
     *
     * @param request request
     * @return ip
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("Proxy-Client-IP");
        // todo
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("WL-Proxy-Client-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (Constants.LOCAL_HOST.equals(ip)) {
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = Constants.LOCAL_HOST;
        }
        return ip;
    }

    /**
     * 获取客户端主机名称
     *
     * @return hostName
     */
    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {

        }
        return "未知";
    }

    /**
     * 获取 ip 地址
     *
     * @param ip ip
     * @return ip 地址
     * @throws Exception Exception
     */
    public static String getIpSource(String ip) throws Exception {
        DbConfig config = new DbConfig();
        String path = "config/ip2region.db";
        String name = "ip2region.db";
        File file = FileUtils.inputStreamToFile(new ClassPathResource(path).getStream(), name);
        DbSearcher searcher = new DbSearcher(config, file.getParent());
        DataBlock dataBlock = searcher.btreeSearch(ip);
        String address = dataBlock.getRegion().replace("0|", "");
        if (address.charAt(address.length() - 1) == '|') {
            address = address.substring(0, address.length() - 1);
        }
        return address.equals(Constants.REGION) ? Constants.INTRANET_IP : address;
    }

    /**
     * 获取游览器名称
     *
     * @param request request
     * @return return
     */
    public static String getBrowser(HttpServletRequest request) {
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();
        return browser.getName();
    }

    /**
     * 获取操作系统名称
     *
     * @param request request
     * @return return
     */
    public static String getSystemName(HttpServletRequest request) {
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        return userAgent.getOperatingSystem().getName();
    }
}

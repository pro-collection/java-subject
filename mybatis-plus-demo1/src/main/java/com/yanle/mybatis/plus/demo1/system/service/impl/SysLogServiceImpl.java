package com.yanle.mybatis.plus.demo1.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.common.utils.IpInfoUtils;
import com.yanle.mybatis.plus.demo1.common.utils.UUIDUtils;
import com.yanle.mybatis.plus.demo1.system.dao.SysLogDao;
import com.yanle.mybatis.plus.demo1.system.entity.SysLog;
import com.yanle.mybatis.plus.demo1.system.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
@Slf4j
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public int saveLoginLog(HttpServletRequest request, String message, String name) {
        try {
            String ipAddr = IpInfoUtils.getIpAddress(request);
            String ipSource = IpInfoUtils.getIpSource(ipAddr);
            String browser = IpInfoUtils.getBrowser(request);
            String systemName = IpInfoUtils.getSystemName(request);
            SysLog sysLog = SysLog.builder()
                    .username(name)
                    .browserName(browser)
                    .createDate(new Date())
                    .id(UUIDUtils.getUUID())
                    .ipAddress(ipAddr)
                    .ipSource(ipSource)
                    .message(message)
                    .systemName(systemName)
                    .build();
            return sysLogDao.insert(sysLog);
        } catch (Exception e) {
            log.error("获取ip来源出错");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public IPage<SysLog> findSysLogPage(Page page) {
        return null;
    }
}

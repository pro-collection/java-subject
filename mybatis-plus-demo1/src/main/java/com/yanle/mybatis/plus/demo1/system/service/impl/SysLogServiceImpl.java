package com.yanle.mybatis.plus.demo1.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.system.dao.SysLogDao;
import com.yanle.mybatis.plus.demo1.system.entity.SysLog;
import com.yanle.mybatis.plus.demo1.system.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@Slf4j
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public int saveLoginLog(HttpServletRequest request, String message, String name) {
        return 0;
    }

    @Override
    public IPage<SysLog> findSysLogPage(Page page) {
        return null;
    }
}

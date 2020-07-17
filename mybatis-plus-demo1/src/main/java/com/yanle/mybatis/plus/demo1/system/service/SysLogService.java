package com.yanle.mybatis.plus.demo1.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.system.entity.SysLog;

import javax.servlet.http.HttpServletRequest;

public interface SysLogService {
    int saveLoginLog(HttpServletRequest request, String message, String name);

    IPage<SysLog> findSysLogPage(Page page);
}

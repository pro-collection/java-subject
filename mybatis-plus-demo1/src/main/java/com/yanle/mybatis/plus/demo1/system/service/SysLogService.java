package com.yanle.mybatis.plus.demo1.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.servlet.http.HttpServletRequest;

public interface SysLogService {
    int saveLoginLog(HttpServletRequest request, String message, String name);

}

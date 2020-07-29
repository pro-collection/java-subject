package com.yanle.mybatis.plus.demo1.system.restfulController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.common.base.ApiResponse;
import com.yanle.mybatis.plus.demo1.system.entity.SysLog;
import com.yanle.mybatis.plus.demo1.system.service.SysLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/sysLog")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysLogRestController {
    private final SysLogService sysLogService;

    @GetMapping("/geSysLoglist")
    public ApiResponse getMenuList(
            @RequestParam("page") int page,
            @RequestParam("page_size") int pageSize
    ) {
        IPage<SysLog> syslogPage = sysLogService.findSysLogPage(new Page(page, pageSize));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total", syslogPage.getTotal());
        jsonObject.put("sysLogList", syslogPage.getRecords());
        jsonObject.put("page", syslogPage.getCurrent());
        jsonObject.put("page_size", syslogPage.getSize());
        return ApiResponse.ofSuccess(jsonObject);
    }
}

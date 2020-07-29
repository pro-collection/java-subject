package com.yanle.mybatis.plus.demo1.system.restfulController;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/system/rest")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SystemInfoRestController {
    private final SystemInfoService systemInfoService;
}

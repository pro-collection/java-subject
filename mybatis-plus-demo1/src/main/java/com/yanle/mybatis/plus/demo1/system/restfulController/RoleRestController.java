package com.yanle.mybatis.plus.demo1.system.restfulController;

import com.yanle.mybatis.plus.demo1.system.service.SysMenuRoleService;
import com.yanle.mybatis.plus.demo1.system.service.SysMenuService;
import com.yanle.mybatis.plus.demo1.system.service.SysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/rule")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleRestController {
    private final SysRoleService sysRoleService;
    private final SysMenuService sysMenuService;
    private final SysMenuRoleService sysMenuService;


}

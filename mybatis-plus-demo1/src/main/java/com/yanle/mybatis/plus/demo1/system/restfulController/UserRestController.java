package com.yanle.mybatis.plus.demo1.system.restfulController;

import com.yanle.mybatis.plus.demo1.system.service.SysRoleService;
import com.yanle.mybatis.plus.demo1.system.service.SysUserRoleService;
import com.yanle.mybatis.plus.demo1.system.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserRestController {
    private final SysUserService userService;

    private final SysRoleService sysRoleService;

    private final SysUserRoleService sysUserRoleService;
}

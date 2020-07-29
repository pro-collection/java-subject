package com.yanle.mybatis.plus.demo1.system.restfulController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.common.base.ApiResponse;
import com.yanle.mybatis.plus.demo1.system.entity.SysRole;
import com.yanle.mybatis.plus.demo1.system.service.SysMenuRoleService;
import com.yanle.mybatis.plus.demo1.system.service.SysMenuService;
import com.yanle.mybatis.plus.demo1.system.service.SysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/rule")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleRestController {
    private final SysRoleService sysRoleService;
    private final SysMenuService sysMenuService;
    private final SysMenuRoleService sysMenuRoleService;

    @GetMapping("/getRoleInfo")
    public ApiResponse getRoleInfo(
            @RequestParam("page") int page,
            @RequestParam("page_size") int pageSize
    ) {
        JSONObject jsonObject = new JSONObject();
        IPage<SysRole> sysRoleList = sysRoleService.getAll(new Page(page, pageSize));
        jsonObject.put("total", sysRoleList.getTotal());
        jsonObject.put("page", sysRoleList.getCurrent());
        jsonObject.put("page_size", sysRoleList.getSize());
        jsonObject.put("sysRoleList", sysRoleList.getRecords());
        return ApiResponse.ofSuccess(jsonObject);
    }


}

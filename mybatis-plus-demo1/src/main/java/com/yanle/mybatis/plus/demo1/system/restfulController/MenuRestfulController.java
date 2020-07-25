package com.yanle.mybatis.plus.demo1.system.restfulController;

import com.alibaba.fastjson.JSONObject;
import com.yanle.mybatis.plus.demo1.common.base.ApiResponse;
import com.yanle.mybatis.plus.demo1.common.utils.SecurityUtils;
import com.yanle.mybatis.plus.demo1.system.service.SysMenuService;
import com.yanle.mybatis.plus.demo1.system.vo.MenuVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/web/menu")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenuRestfulController {
    private final SysMenuService sysMenuService;

    @GetMapping("/getMenulist")
    public ApiResponse getMenuList() {
        // 获取登录用户信息
        Authentication userAuthentication = SecurityUtils.getCurrentUserAuthentication();
        String name = userAuthentication.getName();
        List<MenuVo> menuVoList = sysMenuService.getMenuByUser(name);
        JSONObject data = new JSONObject(16);
        data.put("name", name);
        data.put("menuList", menuVoList);
        return ApiResponse.ofSuccess(data);
    }

    @GetMapping("/getMenuInfo")
    public ApiResponse getMenuInfo(
            @RequestParam("page") int page,
            @RequestParam("page_size") int pageSize
    ) {
        JSONObject jsonObject = new JSONObject();
        // TODO
    }
}

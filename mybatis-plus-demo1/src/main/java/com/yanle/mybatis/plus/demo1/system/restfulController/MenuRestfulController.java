package com.yanle.mybatis.plus.demo1.system.restfulController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.common.base.ApiResponse;
import com.yanle.mybatis.plus.demo1.common.utils.SecurityUtils;
import com.yanle.mybatis.plus.demo1.common.utils.UUIDUtils;
import com.yanle.mybatis.plus.demo1.system.config.exception.BusinessInterfaceException;
import com.yanle.mybatis.plus.demo1.system.entity.SysMenu;
import com.yanle.mybatis.plus.demo1.system.service.SysMenuService;
import com.yanle.mybatis.plus.demo1.system.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/web/menu")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenuRestfulController {
    private final SysMenuService sysMenuService;

    @GetMapping("/getMenulist")
    public ApiResponse getMenuList() throws BusinessInterfaceException {
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
        List<MenuListVo> listVoList = new LinkedList<>();
        IPage<SysMenu> firstMenu = sysMenuService.findFirstMenu(new Page(page, pageSize));
        // 组装数据
        List<SysMenu> firstMenuList = firstMenu.getRecords();
        firstMenuList.forEach(sysMenu -> {
            List<SysMenu> secondMenu = sysMenuService.findMenuListByUser(sysMenu.getId());
            MenuListVo currentMenuItemVo = MenuListVo.
                    builder()
                    .id(sysMenu.getId())
                    .children(secondMenu)
                    .isShow(sysMenu.getIsShow())
                    .menuCode(sysMenu.getMenuCode())
                    .menuHref(sysMenu.getMenuHref())
                    .menuIcon(sysMenu.getMenuIcon())
                    .menuLevel(sysMenu.getMenuLevel())
                    .menuName(sysMenu.getMenuName())
                    .menuWeight(sysMenu.getMenuWeight())
                    .build();
            listVoList.add(currentMenuItemVo);
        });
        jsonObject.put("total", firstMenu.getTotal());
        jsonObject.put("page", firstMenu.getCurrent());
        jsonObject.put("page_size", firstMenu.getSize());
        jsonObject.put("menuList", listVoList);
        return ApiResponse.ofSuccess(jsonObject);
    }

    @GetMapping("/deleteMenu")
    public ApiResponse deleteMenu(@RequestParam("id") String id) {
        JSONObject jsonObject = new JSONObject();
        try {
            if (sysMenuService.deleteMenuById(id) > 0) {
                jsonObject.put("code", 200);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("code", 500);
        }
        return ApiResponse.ofSuccess(jsonObject);
    }

    @PostMapping("/updateMenu")
    public ApiResponse updateMenu(@RequestBody SysMenuNameVO sysMenuNameVO) {
        JSONObject jsonObject = new JSONObject();
        SysMenuVO sysMenu = new SysMenuVO(sysMenuNameVO.getId(),
                sysMenuService.getByMenuName(sysMenuNameVO.getMenuNames()),
                sysMenuNameVO.getMenuName(),
                sysMenuNameVO.getMenuCode(),
                sysMenuNameVO.getMenuHref(),
                sysMenuNameVO.getMenuIcon(),
                sysMenuNameVO.getMenuLevel(),
                sysMenuNameVO.getMenuWeight(),
                sysMenuNameVO.getIsShow(),
                null,
                null
        );
        try {
            if (sysMenuService.updateMenu(sysMenu) > 0) {
                jsonObject.put("code", 200);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("code", 500);
        }
        return ApiResponse.ofSuccess(jsonObject);
    }

    @PostMapping("/addMenu")
    public ApiResponse addMenu(@RequestBody SysMenuNameVO sysMenuNameVO) {
        JSONObject jsonObject = new JSONObject();
        SysMenu menu = sysMenuService.getByName(
                sysMenuNameVO.getMenuName(),
                sysMenuNameVO.getMenuCode(),
                sysMenuNameVO.getMenuHref()
        );
        if (menu == null) {
            Authentication authentication = SecurityUtils.getCurrentUserAuthentication();
            SysMenuVO sysMenuVO = new SysMenuVO(
                    UUIDUtils.getUUID(),
                    sysMenuService.getByMenuName(sysMenuNameVO.getMenuNames()),
                    sysMenuNameVO.getMenuName(),
                    sysMenuNameVO.getMenuCode(),
                    sysMenuNameVO.getMenuHref(),
                    sysMenuNameVO.getMenuIcon(),
                    sysMenuNameVO.getMenuLevel(),
                    sysMenuNameVO.getMenuWeight(),
                    sysMenuNameVO.getIsShow(),
                    new Date(),
                    (String) authentication.getPrincipal()
            );
            try {
                if (sysMenuService.addMenu(sysMenuVO) > 0) {
                    jsonObject.put("code", 200);
                }
            } catch (Exception e) {
                e.printStackTrace();
                jsonObject.put("code", 500);
            }
        } else {
            jsonObject.put("code", 501);
        }
        return ApiResponse.ofSuccess(jsonObject);
    }

    @GetMapping("/getMenuLevel")
    public ApiResponse getMenuLevel() {
        JSONObject jsonObject = new JSONObject();
        List<String> menuLevel = sysMenuService.getMenuLevel();
        jsonObject.put("menuLevel", menuLevel);
        return ApiResponse.ofSuccess(jsonObject);
    }

    @GetMapping("/getPreviousMenu")
    public ApiResponse getPreviousMenu(@RequestParam("menuLevel") String menuLevel) {
        JSONObject jsonObject = new JSONObject();
        List<MenuNameVO> menuNames = sysMenuService.getPreviousMenu(String.valueOf((Integer.parseInt(menuLevel) - 1)));
        jsonObject.put("menuNames",menuNames);
        return ApiResponse.ofSuccess(jsonObject);
    }
}

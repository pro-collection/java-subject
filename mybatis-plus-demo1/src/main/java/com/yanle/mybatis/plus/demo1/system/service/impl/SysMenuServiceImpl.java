package com.yanle.mybatis.plus.demo1.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.system.dao.SysMenuDao;
import com.yanle.mybatis.plus.demo1.system.dao.SysRoleDao;
import com.yanle.mybatis.plus.demo1.system.entity.SysMenu;
import com.yanle.mybatis.plus.demo1.system.entity.SysRole;
import com.yanle.mybatis.plus.demo1.system.service.SysMenuService;
import com.yanle.mybatis.plus.demo1.system.vo.MenuNameVO;
import com.yanle.mybatis.plus.demo1.system.vo.MenuVo;
import com.yanle.mybatis.plus.demo1.system.vo.SysMenuVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<MenuVo> getMenuByUser(String username) throws NullPointerException {
        // 获取用户信息
        SysRole sysRole = sysRoleDao.findByName(username);
        if (sysRole == null) return null;

        List<SysMenu> sysMenus = sysMenuDao.findByRoleId(sysRole.getId());
        List<MenuVo> menuVoList = new ArrayList<>();

        // 获取一级菜单
        List<SysMenu> firstLevel = sysMenus
                .stream()
                .filter(item -> item.getParentId() == null)
                .collect(Collectors.toList());
        // 拼接二级菜单
        for (SysMenu sysMenu : firstLevel) {
            List<SysMenu> secondMenuList = new LinkedList<>();
            for (SysMenu menu : sysMenus) {
                if (StringUtils.equals(menu.getParentId(), sysMenu.getId()))
                    secondMenuList.add(menu);
            }

            MenuVo currentMenuVo = MenuVo.builder()
                    .name(sysMenu.getMenuName())
                    .code(sysMenu.getMenuCode())
                    .icon(sysMenu.getMenuIcon())
                    .sysMenus(secondMenuList)
                    .build();

            menuVoList.add(currentMenuVo);
        }
        return menuVoList;
    }

    @Override
    public List<SysMenu> findMenuListByUser(String username) {
        // 获取用户menu
        SysRole sysRole = sysRoleDao.findByName(username);
        return sysMenuDao.findByRoleId(sysRole.getId());
    }

    @Override
    public IPage<SysMenu> findFirstMenu(Page page) {
        return sysMenuDao.findFirstMenu(page);
    }

    @Override
    public List<SysMenu> findByParentId(String parentId) {
        return sysMenuDao.findByParentId(parentId);
    }

    @Override
    public int updateMenu(SysMenuVO sysMenu) {
        return 0;
    }

    @Override
    public int addMenu(SysMenuVO sysMenu) {
        return 0;
    }

    @Override
    public SysMenu getByName(String menuName, String menuCode, String menuHref) {
        return null;
    }

    @Override
    public SysMenu getById(String id) {
        return null;
    }

    @Override
    public List<SysMenu> getFirstMenu() {
        return null;
    }

    @Override
    public List<SysMenu> getSecondMenu() {
        return null;
    }

    @Override
    public List<String> getRoleMenu(String roleId) {
        return null;
    }

    @Override
    public List<String> getMenuLevel() {
        return null;
    }

    @Override
    public List<MenuNameVO> getPreviousMenu(String menuLevel) {
        return null;
    }

    @Override
    public String getByMenuName(String menuNames) {
        return null;
    }

    @Override
    public int deleteMenuById(String id) {
        return 0;
    }
}

package com.yanle.mybatis.plus.demo1.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.system.entity.SysMenu;
import com.yanle.mybatis.plus.demo1.system.service.SysMenuService;
import com.yanle.mybatis.plus.demo1.system.vo.MenuNameVO;
import com.yanle.mybatis.plus.demo1.system.vo.MenuVo;
import com.yanle.mybatis.plus.demo1.system.vo.SysMenuVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Override
    public List<MenuVo> getMenuByUser(String username) {
        return null;
    }

    @Override
    public List<SysMenu> findMenuListByUser(String username) {
        return null;
    }

    @Override
    public IPage<SysMenu> findFirstMenu(Page page) {
        return null;
    }

    @Override
    public List<SysMenu> findByParentId(String parentId) {
        return null;
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

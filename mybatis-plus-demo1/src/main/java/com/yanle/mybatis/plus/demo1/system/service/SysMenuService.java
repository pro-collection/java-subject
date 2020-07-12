package com.yanle.mybatis.plus.demo1.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.system.vo.MenuVo;
import com.yanle.mybatis.plus.demo1.system.entity.SysMenu;
import com.yanle.mybatis.plus.demo1.system.vo.SysMenuVO;

import java.util.List;

public interface SysMenuService {
    List<MenuVo> getMenuByUser(String username);

    List<SysMenu> findMenuListByUser(String username);

    IPage<SysMenu> findFirstMenu(Page page);

    List<SysMenu> findByParentId(String parentId);

    /**
     * 修改菜单
     * @param sysMenu 菜单
     * @return return
     */
    int updateMenu(SysMenuVO sysMenu);

    /**
     * 添加菜单
     * @param sysMenu 菜单
     * @return return
     */
    int addMenu(SysMenuVO sysMenu);

    /**
     * 查询菜单
     * @param menuName 名称
     * @param menuCode 别名
     * @param menuHref 链接
     * @return return
     */
    SysMenu getByName(String menuName, String menuCode, String menuHref);


}

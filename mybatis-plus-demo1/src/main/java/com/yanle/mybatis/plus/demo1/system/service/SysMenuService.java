package com.yanle.mybatis.plus.demo1.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.system.vo.MenuVo;
import com.yanle.mybatis.plus.demo1.system.entity.SysMenu;

import java.util.List;

public interface SysMenuService {
    List<MenuVo> getMenuByUser(String username);

    List<SysMenu> findMenuListByUser(String username);

    IPage<SysMenu> findFirstMenu(Page page);

    List<SysMenu> findByParentId(String parentId);
}

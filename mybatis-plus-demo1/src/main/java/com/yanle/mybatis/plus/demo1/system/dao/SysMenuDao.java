package com.yanle.mybatis.plus.demo1.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.system.entity.SysMenu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuDao extends BaseMapper<SysMenu> {
    @Select("select * from sys_menu as m left join sys_menu_role as r " +
            "on m.id = r.menu_id where m.is_show = '1' and r.role_id = #{roleId} " +
            "order by m.menu_weight")
    List<SysMenu> findByRoleId(@Param("roleId") String roleId);

    @Select("select * from sys_menu where menu_level = 1 order by menu_weight")
    IPage<SysMenu> findFirstMenu(Page page);


}

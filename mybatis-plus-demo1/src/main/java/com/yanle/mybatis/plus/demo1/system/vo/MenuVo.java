package com.yanle.mybatis.plus.demo1.system.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MenuVo {
    private String name;
    private String icon;
    private String code;
    private List<SysMenu> sysMenus;
}

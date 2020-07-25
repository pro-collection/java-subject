package com.yanle.mybatis.plus.demo1.system.vo;

import com.yanle.mybatis.plus.demo1.system.entity.SysMenu;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MenuListVo {
    private String id;
    private String menuName;
    private String menuCode;
    private String menuHref;
    private String menuIcon;
    private String menuLevel;
    private String menuWeight;
    private Boolean isShow;
    private List<SysMenu> children;
}

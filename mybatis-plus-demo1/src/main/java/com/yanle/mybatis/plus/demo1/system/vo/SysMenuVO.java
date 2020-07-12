package com.yanle.mybatis.plus.demo1.system.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysMenuVO implements Serializable {

    private static final long serialVersionUID = -3194727281673759817L;

    private String id;

    private String parentId;

    private String menuName;

    private String menuCode;

    private String menuHref;

    private String menuIcon;

    private String menuLevel;

    private String menuWeight;

    private String isShow;

    private Date createDate;

    private String createBy;

    public SysMenuVO() {
    }

    public SysMenuVO(String id, String parentId, String menuName, String menuCode, String menuHref, String menuIcon, String menuLevel, String menuWeight, String isShow, Date createDate, String createBy) {
        this.id = id;
        this.parentId = parentId;
        this.menuName = menuName;
        this.menuCode = menuCode;
        this.menuHref = menuHref;
        this.menuIcon = menuIcon;
        this.menuLevel = menuLevel;
        this.menuWeight = menuWeight;
        this.isShow = isShow;
        this.createDate = createDate;
        this.createBy = createBy;
    }
}

package com.yanle.mybatis.plus.demo1.system.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysMenuNameVO extends SysMenuVO {
    private String menuNames;

    public SysMenuNameVO() {
    }
}

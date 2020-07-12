package com.yanle.mybatis.plus.demo1.system.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuNameVO {
    private String id;
    private String menuName;
}

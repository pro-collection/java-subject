package com.yanle.mybatis.plus.demo1.common.utils;

import java.util.UUID;

public class UUIDUtils {

    /*
    * 生成UUID
    * */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getSimpleUUID() {
        return UUID.randomUUID().toString();
    }

    public static String getShortUUID() {
        return getUUID().substring(16);
    }
}

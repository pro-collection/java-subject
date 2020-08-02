package com.yanle.mybatis.plus.study.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("insertFill!!!!");
        // 第一个参数是实体类中的名， 不是数据库中的名
        // 其实该方法虽然是可以用， 但是官方已经不推荐使用了， 可以用下面的方法
        // setInsertFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("updateFill!!!!");
//        setUpdateFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}

package com.yanle.mybatis.plus.demo1.system.service.impl;

import com.yanle.mybatis.plus.demo1.system.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Override
    public String getCodeVal(String key) {
        return null;
    }

    @Override
    public void saveCode(String key, Object val) {

    }

    @Override
    public void delete(String key) {

    }
}

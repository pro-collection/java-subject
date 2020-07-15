package com.yanle.mybatis.plus.demo1.system.service.impl;

import com.yanle.mybatis.plus.demo1.common.utils.RedisUtils;
import com.yanle.mybatis.plus.demo1.system.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisUtils redisUtils;

    @Value("${loginCode.expiration}")
    private Long expiration;

    @Override
    public String getCodeVal(String key) {
        try {
            return Objects.requireNonNull(redisUtils.get(key)).toString();
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public void saveCode(String key, Object val) {
        redisUtils.set(key, val, expiration, TimeUnit.SECONDS);
    }

    @Override
    public void delete(String key) {
        redisUtils.remove(key);
    }
}

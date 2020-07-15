package com.yanle.mybatis.plus.demo1.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 写入缓存
     * @param key   key
     * @param value value
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    public boolean set(String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     * @param key key
     * @param value value
     * @param expireTime 失效时间
     * @param timeUnit 失效时间单位
     * @return return
     */
    @SuppressWarnings("unchecked")
    public boolean set(String key, Object value, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            redisTemplate.expire(key, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}

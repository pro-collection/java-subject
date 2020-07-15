package com.yanle.mybatis.plus.demo1.system.service;

public interface RedisService {
    /**
     * 查询验证码的值
     * @param key key
     * @return string
     */
    String getCodeVal(String key);

    /**
     * 保存验证码
     * @param key key
     * @param val val
     */
    void saveCode(String key, Object val);

    /**
     * 删除验证码
     * @param key
     */
    void delete(String key);
}

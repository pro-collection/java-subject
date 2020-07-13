package com.yanle.mybatis.plus.demo1.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yanle.mybatis.plus.demo1.system.entity.SysUser;
import com.yanle.mybatis.plus.demo1.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.Page;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Override
    public SysUser findByName(String name) {
        return null;
    }

    @Override
    public IPage<SysUser> getAll(Page page) {
        return null;
    }

    @Override
    public SysUser getById(String id) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public int updateById(SysUser sysUser) {
        return 0;
    }

    @Override
    public int insert(SysUser sysUser) {
        return 0;
    }

    @Override
    public int updatePasswordById(String password, String id) {
        return 0;
    }
}

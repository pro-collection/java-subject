package com.yanle.mybatis.plus.demo1.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yanle.mybatis.plus.demo1.system.dao.SysUserDao;
import com.yanle.mybatis.plus.demo1.system.entity.SysUser;
import com.yanle.mybatis.plus.demo1.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser findByName(String name) {
        return sysUserDao.findByName(name);
    }

    @Override
    public IPage<SysUser> getAll(Page page) {
        return sysUserDao.getAll(page);
    }

    @Override
    public SysUser getById(String id) {
        return sysUserDao.getById(id);
    }

    @Override
    public int deleteById(String id) {
        return sysUserDao.deleteById(id);
    }

    @Override
    public int updateById(SysUser sysUser) {
        return sysUserDao.updateById(sysUser);
    }

    @Override
    public int insert(SysUser sysUser) {
        return sysUserDao.insert(sysUser);
    }

    @Override
    public int updatePasswordById(String password, String id) {
        return sysUserDao.updatePasswordById(password, id);
    }
}

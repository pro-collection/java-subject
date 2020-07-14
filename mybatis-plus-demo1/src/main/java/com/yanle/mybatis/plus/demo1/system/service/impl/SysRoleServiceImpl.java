package com.yanle.mybatis.plus.demo1.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.system.dao.SysRoleDao;
import com.yanle.mybatis.plus.demo1.system.entity.SysRole;
import com.yanle.mybatis.plus.demo1.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public SysRole findByUserId(String userId) {
        return sysRoleDao.findByUserId(userId);
    }

    @Override
    public IPage<SysRole> getAll(Page page) {
        return sysRoleDao.getAll(page);
    }

    @Override
    public SysRole getByName(String name) {
        return sysRoleDao.getByName(name);
    }

    @Override
    public String getRoleNameById(String id) {
        return sysRoleDao.getById(id);
    }

    @Override
    public int deleteById(String id) {
        return sysRoleDao.deleteById(id);
    }

    @Override
    public int updateById(SysRole sysRole) {
        return sysRoleDao.updateById(sysRole);
    }

    @Override
    public int insert(SysRole sysRole) {
        return sysRoleDao.insert(sysRole);
    }

    @Override
    public List<String> getAllRoleName() {
        return sysRoleDao.getAllRoleName();
    }

    @Override
    public String getIdByName(String name) {
        return sysRoleDao.getIdByName(name);
    }
}

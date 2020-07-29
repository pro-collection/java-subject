package com.yanle.mybatis.plus.demo1.system.service.impl;

import com.yanle.mybatis.plus.demo1.system.dao.SysUserRoleDao;
import com.yanle.mybatis.plus.demo1.system.entity.SysUserRole;
import com.yanle.mybatis.plus.demo1.system.service.SysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysUserRoleServiceImpl implements SysUserRoleService {

    private final SysUserRoleDao sysUserRoleDao;

    @Override
    public int insert(SysUserRole sysUserRole) {
        return sysUserRoleDao.insert(sysUserRole);
    }

    @Override
    public int deleteByUserId(String userId) {
        return sysUserRoleDao.deleteByUserId(userId);
    }
}
package com.yanle.mybatis.plus.demo1.system.service.impl;

import com.yanle.mybatis.plus.demo1.system.entity.SysMenuRole;
import com.yanle.mybatis.plus.demo1.system.service.SysMenuRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysMenuRoleServiceImpl implements SysMenuRoleService {
    private final SysMenuRoleDao sysMenuRoleDao;

    @Override
    public int addMenuRole(SysMenuRole sysMenuRole) {
        return 0;
    }

    @Override
    public int deleteByRoleId(String roleId) {
        return 0;
    }

    @Override
    public List<String> getAllMenuId(String roleId, List<String> parentIds) {
        return null;
    }
}

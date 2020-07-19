package com.yanle.mybatis.plus.demo1.system.config.security;

import com.yanle.mybatis.plus.demo1.system.entity.SysRole;
import com.yanle.mybatis.plus.demo1.system.entity.SysUser;
import com.yanle.mybatis.plus.demo1.system.service.SysRoleService;
import com.yanle.mybatis.plus.demo1.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SysUser sysUser = sysUserService.findByName(username);
        if (sysUser != null) {
            SysRole sysRole = sysRoleService.findByUserId(sysUser.getId());
            authorities.add(new SimpleGrantedAuthority(sysRole.getAuthority()));
            return new User(username, sysUser.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("用户不存在");
        }
    }
}

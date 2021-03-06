package com.ibms.demo.service;

import com.github.pagehelper.PageHelper;
import com.ibms.demo.common.Util;
import com.ibms.demo.mapper.UserMapper;
import com.ibms.demo.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gyh on 2021/2/3
 */
@Service
public class UserService implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @Resource
    UserMapper userMapper;
    final PasswordEncoder passwordEncoder;
    final RoleService roleService;
    final UnitService unitService;

    public UserService(PasswordEncoder passwordEncoder, RoleService roleService, UnitService unitService) {
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.unitService = unitService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(s);
        if (null == user) throw new UsernameNotFoundException("用户：" + s + "不存在");
        return user;
    }

    public User findUserById(Integer id) {
        id = id == null ? Util.getCurrentUser().getId() : id;
        return userMapper.findUserRoleById(id);
    }

    public PageView<User> getAllUser(int page, int offset) {
        PageHelper.startPage(page, offset);
        return PageView.build(userMapper.findAll());
    }

    public Integer deleteUserById(Integer id) {
        if (id == 1) throw new IllegalStateException("不能删除超级管理员");
        unitService.updateUnitByUserId(id);
        return userMapper.deleteUserById(id);
    }

    /**
     * 注册用户，并添加默认角色{@link Role#ADMIN}
     * @param user user
     * @return user
     */
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.save(user);
        roleService.addRoleToUser(user.getId(), Role.USER, null);
        return user;
    }

    public Integer update(User user) {
        Integer id = Util.getCurrentUser().getId();
        // 如果修改的用户是自己或者自己是超级管理员就允许修改
        if (id.equals(user.getId()) || id == 1) {
            if (user.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            return userMapper.update(user);
        } else throw new IllegalStateException("不能修改");
    }
}

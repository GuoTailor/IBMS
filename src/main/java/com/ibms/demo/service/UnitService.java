package com.ibms.demo.service;

import com.github.pagehelper.PageHelper;
import com.ibms.demo.mapper.UnitMapper;
import com.ibms.demo.pojo.PageView;
import com.ibms.demo.pojo.Role;
import com.ibms.demo.pojo.Unit;
import com.ibms.demo.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gyh on 2021/2/6
 */
@Service
@Transactional
public class UnitService {
    @Resource
    private UnitMapper unitMapper;
    @Autowired
    private RoleService roleService;

    public Unit findById(Integer id) {
        return unitMapper.selectByPrimaryKey(id);
    }

    public PageView<Unit> getAllUnit(int page, int offset) {
        PageHelper.startPage(page, offset);
        return PageView.build(unitMapper.findAll());
    }

    public Unit createUnit(Unit unit) {
        unitMapper.insertSelective(unit);
        List<UserRole> roles = roleService.findByUserIdAndRoleId(unit.getUserId(), Role.USER);
        UserRole userRole = roles.stream().filter(it -> it.getUnitId() == null).findFirst().orElse(null);
        if (userRole == null) {
            roleService.addRoleToUser(unit.getUserId(), Role.ADMIN, unit.getId());
        } else {
            roleService.updateRoleById(Role.ADMIN, userRole.getId(), unit.getId());
        }
        return unit;
    }

    public int updateUnit(Unit unit) {
        if (unit.getId() == null) throw new IllegalStateException("id不能为空");
        if (unit.getUserId() != null) {
            List<UserRole> roles = roleService.findByUserIdAndRoleId(unit.getUserId(), Role.USER);
            UserRole userRole = roles.stream().filter(it -> it.getUnitId() == null).findFirst().orElse(null);
            if (userRole == null) {
                roleService.updateRoleByUserIdAndUnitId(Role.ADMIN, unit.getUserId(), unit.getId());
            } else {
                // 当userRole != null时说明用户还没有绑定过单位
                roleService.updateRoleById(Role.ADMIN, userRole.getId(), unit.getId());
            }
        }
        return unitMapper.updateByPrimaryKeySelective(unit);
    }

    public long updateUnitByUserId(Integer userId) {
        List<Unit> units = unitMapper.findByUserId(userId);
        return units.stream().map(it -> {
            it.setUserId(null);
            return unitMapper.updateByPrimaryKey(it);
        }).count();
    }

    public int removeUnit(Integer id) {
        return unitMapper.deleteByPrimaryKey(id);
    }
}

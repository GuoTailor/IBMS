package com.ibms.demo.service;

import com.github.pagehelper.PageHelper;
import com.ibms.demo.common.Util;
import com.ibms.demo.mapper.BuildingMapper;
import com.ibms.demo.mapper.RoleMapper;
import com.ibms.demo.pojo.Building;
import com.ibms.demo.pojo.PageView;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by gyh on 2021/2/6
 */
@Service
public class BuildingService {
    @Resource
    private BuildingMapper buildingMapper;
    @Resource
    private RoleMapper roleMapper;

    public PageView<Building> getBuildingList(int page, int size, Integer parentId) {
        // 如果层不为空就返回房间
        if (parentId != null) {
            PageHelper.startPage(page, size);
            return PageView.build(buildingMapper.findAllByParentId(parentId));
        } else {
            Integer userId = Util.getCurrentUser().getId();
            Integer unitId = roleMapper.findRoleByUserId(userId).get(0).getUnitId();
            PageHelper.startPage(page, size);
            return PageView.build(buildingMapper.findAllByUnitId(unitId));
        }
    }

    public Building createBuilding(Building building) {
        if (!building.checkType()) throw new IllegalStateException("不支持的类型:type=" + building.getType());
        if (!building.getType().equals(Building.BUILDING)) {
            Integer parentType = buildingMapper.findTypeById(building.getParentId());
            if (!building.isParentType(parentType))
                throw new IllegalStateException("父类型和当前类型不满足:type=" + building.getType() + " parentType:" + parentType);
        }
        Integer userId = Util.getCurrentUser().getId();
        Integer unitId = roleMapper.findRoleByUserId(userId).get(0).getUnitId();
        building.setUnitId(unitId);
        buildingMapper.insertSelective(building);
        return building;
    }

    /**
     * 更新楼宇的信息。
     * 不能修改楼宇的父类id，不能修改楼宇的类型，不能修改楼宇的部门id
     *
     * @param building building
     * @return 受影响的行数
     */
    public int updateBuilding(Building building) {
        if (building.getId() == null) throw new IllegalStateException("id不能为空");
        Building currentBuilding = buildingMapper.selectByPrimaryKey(building.getId());
        checkUnitId(currentBuilding.getUnitId());
        building.setType(null);
        building.setParentId(null);
        building.setUnitId(null);
        return buildingMapper.updateByPrimaryKeySelective(building);
    }

    public int removeBuilding(Integer id) {
        Building currentBuilding = buildingMapper.selectByPrimaryKey(id);
        checkUnitId(currentBuilding.getUnitId());
        return buildingMapper.deleteByPrimaryKey(id);
    }

    public void checkUnitId(Integer unitId) {
        Integer userId = Util.getCurrentUser().getId();
        roleMapper.findRoleByUserId(userId)
                .stream()
                .filter(r -> r.getUnitId().equals(unitId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("当前用户不能管理单位：:" + unitId));
    }
}

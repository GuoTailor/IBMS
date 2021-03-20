package com.ibms.demo.service;

import com.github.pagehelper.PageHelper;
import com.ibms.demo.mapper.UnitMapper;
import com.ibms.demo.pojo.PageView;
import com.ibms.demo.pojo.Unit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by gyh on 2021/2/6
 */
@Service
public class UnitService {
    @Resource
    private UnitMapper unitMapper;

    public Unit findById(Integer id) {
        return unitMapper.selectByPrimaryKey(id);
    }

    public PageView<Unit> getAllUnit(int page, int offset) {
        PageHelper.startPage(page, offset);
        return PageView.build(unitMapper.findAll());
    }

    public Unit createUnit(Unit unit) {
        unitMapper.insertSelective(unit);
        return unit;
    }

    public int updateUnit(Unit unit) {
        if (unit.getId() == null) throw new IllegalStateException("id不能为空");
        return unitMapper.updateByPrimaryKeySelective(unit);
    }

    public int removeUnit(Integer id) {
        return unitMapper.deleteByPrimaryKey(id);
    }
}

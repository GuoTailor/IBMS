package com.ibms.demo.service;

import com.github.pagehelper.PageHelper;
import com.ibms.demo.mapper.ModelMapper;
import com.ibms.demo.pojo.Model;
import com.ibms.demo.pojo.PageView;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by gyh on 2021/2/28
 */
@Service
public class ModelService {
    @Resource
    private ModelMapper modelMapper;

    public PageView<Model> getModeList(int page, int size) {
        PageHelper.startPage(page, size);
        return PageView.build(modelMapper.findAll());
    }

    public int createMode(Model model){
        return modelMapper.insertSelective(model);
    }

    public int updateModel(Model model) {
        return modelMapper.updateByPrimaryKeySelective(model);
    }

    public int deleteModel(Integer id) {
        return modelMapper.deleteByPrimaryKey(id);
    }
}

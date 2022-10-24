package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.entity.EquipmentData;
import com.gxa.entity.EquipmentDataToAdd;
import com.gxa.entity.EquipmentDataToEdit;
import com.gxa.mapper.EquipmentDataMapper;
import com.gxa.service.EquipmentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentDataServiceImpl implements EquipmentDataService {

    @Autowired
    private EquipmentDataMapper equipmentDataMapper;

    @Override
    public PageInfo<EquipmentData> queryAll(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<EquipmentData> equipmentDatas = equipmentDataMapper.queryAllEquipmentData();
        PageInfo<EquipmentData> pageInfo = new PageInfo<>(equipmentDatas);
        return pageInfo;
    }

    @Override
    public void add(EquipmentDataToAdd equipmentDataToAdd) {
        equipmentDataMapper.add(equipmentDataToAdd);
    }

    @Override
    public void update(EquipmentDataToEdit equipmentDataToEdit) {
        equipmentDataMapper.update(equipmentDataToEdit);
    }

    @Override
    public void delete(Integer categoryId) {

        equipmentDataMapper.deleteByCategoryId(categoryId);
    }

    @Override
    public Integer getDataCountInteger(Integer categoryId) {
        Integer dataCountInteger = equipmentDataMapper.getDataCountInteger(categoryId);
        return dataCountInteger;
    }


}

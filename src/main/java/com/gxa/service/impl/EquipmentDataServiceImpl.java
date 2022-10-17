package com.gxa.service.impl;

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
    public List<EquipmentData> queryAll() {
        List<EquipmentData> equipmentDatas = this.equipmentDataMapper.queryAllEquipmentData();
        return equipmentDatas;
    }

    @Override
    public void add(EquipmentDataToAdd equipmentDataToAdd) {
        this.equipmentDataMapper.add(equipmentDataToAdd);
    }

    @Override
    public void update(EquipmentDataToEdit equipmentDataToEdit) {
        this.equipmentDataMapper.update(equipmentDataToEdit);
    }

    @Override
    public void delete(Integer categoryId) {
        this.equipmentDataMapper.deleteByCategoryId(categoryId);
    }

}

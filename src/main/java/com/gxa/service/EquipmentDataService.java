package com.gxa.service;

import com.gxa.entity.EquipmentData;
import com.gxa.entity.EquipmentDataToAdd;
import com.gxa.entity.EquipmentDataToEdit;

import java.util.List;

public interface EquipmentDataService {

    //查询所有的装备分类
    List<EquipmentData> queryAll();

    void add(EquipmentDataToAdd equipmentDataToAdd);

    void update(EquipmentDataToEdit equipmentDataToEdit);

    void delete(Integer categoryId);



}

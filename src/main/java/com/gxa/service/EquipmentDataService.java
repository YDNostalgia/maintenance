package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.entity.EquipmentData;
import com.gxa.entity.EquipmentDataToAdd;
import com.gxa.entity.EquipmentDataToEdit;

public interface EquipmentDataService {

    //查询所有的装备分类
//    List<EquipmentData> queryAll();
    PageInfo<EquipmentData> queryAll(Integer page,Integer limit);
    void add(EquipmentDataToAdd equipmentDataToAdd);

    void update(EquipmentDataToEdit equipmentDataToEdit);

    void delete(Integer categoryId);



}

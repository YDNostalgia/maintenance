package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.entity.EquipmentData;
import com.gxa.entity.EquipmentDataToAdd;
import com.gxa.entity.EquipmentDataToEdit;

public interface EquipmentDataService {


    //分页查询所有的
    PageInfo<EquipmentData> queryAll(Integer page,Integer limit);

    //添加
    void add(EquipmentDataToAdd equipmentDataToAdd);

    //更新
    void update(EquipmentDataToEdit equipmentDataToEdit);

    //删除
    void delete(Integer categoryId);

    //查询资料数

    Integer getDataCountInteger(Integer categoryId);



}

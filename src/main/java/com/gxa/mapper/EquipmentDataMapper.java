package com.gxa.mapper;

import com.gxa.entity.EquipmentData;
import com.gxa.entity.EquipmentDataToAdd;
import com.gxa.entity.EquipmentDataToEdit;

import java.util.List;

public interface EquipmentDataMapper {

    //查询所有的装备分类
    List<EquipmentData> queryAllEquipmentData();


    //添加资料类型
    void add(EquipmentDataToAdd equipmentDataToAdd);

    void update(EquipmentDataToEdit equipmentDataToEdit);

    void deleteByCategoryId(int categoryId);


}

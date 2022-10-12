package com.gxa.service.impl;

import com.gxa.entity.EquipmentManagement;
import com.gxa.mapper.EquipmentManagementMapper;
import com.gxa.service.EquipmentManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentManagementServiceImpl implements EquipmentManagementService {
    @Autowired
    private EquipmentManagementMapper equipmentManagementMapper;
    @Override
    public List<EquipmentManagement> queryAll() {
        List<EquipmentManagement> equipmentManagements=this.equipmentManagementMapper.queryAllEquipmentManagement();
        return equipmentManagements;
    }

    @Override
    public Integer queryCount(EquipmentManagementDto equipmentManagementDto) {
         Integer count=this.equipmentManagementMapper.queryConut(equipmentManagementDto);
        return count;
    }
}

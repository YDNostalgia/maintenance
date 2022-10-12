package com.gxa.service.impl;

import com.gxa.dto.EquipmentManagementDto;
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
    public List<EquipmentManagement> queryAll(EquipmentManagementDto equipmentManagementDto) {
        List<EquipmentManagement> equipmentManagements=this.equipmentManagementMapper.queryAllEquipmentManagement(equipmentManagementDto);
        return equipmentManagements;
    }
}

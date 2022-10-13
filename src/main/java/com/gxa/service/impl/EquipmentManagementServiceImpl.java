package com.gxa.service.impl;

import com.gxa.dto.EquipmentManagementDto;
import com.gxa.entity.*;
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


    @Override
    public Integer queryCount(EquipmentManagementDto equipmentManagementDto) {
        Integer count=this.equipmentManagementMapper.queryConut(equipmentManagementDto);
        return count;
    }

    @Override
    public List<EquipmentClass> queryEquipmentClass() {
        List<EquipmentClass> equipmentClasses=this.equipmentManagementMapper.queryEquipmentClass();
        return equipmentClasses;
    }

    @Override
    public List<EquipmentName> queryEquipmentName() {
        List<EquipmentName> equipmentNames=this.equipmentManagementMapper.queryEquipmentName();
        return equipmentNames;
    }

    @Override
    public List<Useunits> queryEquiUseunits() {
        List<Useunits> useunits=this.equipmentManagementMapper.queryEquipmentUseunits();
        return useunits;
    }

    @Override
    public List<StorageLocation> queryEquipStorageLocation() {
        List<StorageLocation> storageLocations=this.equipmentManagementMapper.queryEquipStorageLocation();
        return storageLocations;
    }
}

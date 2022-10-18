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

    @Override
    public void addEquipmentManagement(EquipmentManagementAU equipmentManagementAU) {
        this.equipmentManagementMapper.addEquipmentManagement(equipmentManagementAU);
    }

    @Override
    public void updateEquipmentManagement(EquipmentManagementAU equipmentManagementAU) {
        this.equipmentManagementMapper.updateEquipmentManagement(equipmentManagementAU);
    }

    @Override
    public void deleteEquipmentManagement(Integer id) {
        this.equipmentManagementMapper.deleteEquipmentManagement(id);
    }

    @Override
    public List<EquipmentList> querylistEquipmentone() {
        List<EquipmentList> equipmentLists=this.equipmentManagementMapper.querylistEquipmentone();
        return equipmentLists;
    }

    @Override
    public List<MaintenanceRecords> querylistMaintenanceRecords() {
        List<MaintenanceRecords> maintenanceRecords=this.equipmentManagementMapper.querylistMaintenanceRecords();
        return maintenanceRecords;
    }

    @Override
    public List<TechnicalData> querylistTechnicalData() {
        List<TechnicalData> technicalData=this.equipmentManagementMapper.querylistTechnicalData();
        return technicalData;
    }

    @Override
    public List<EquipmentClassification> queryAllEquipmentClassifications() {
        List<EquipmentClassification> equipmentClassifications=this.equipmentManagementMapper.queryAllEquipmentClassifications();
        return equipmentClassifications;
    }

    @Override
    public void addEquipmentClassification(EquipmentClass equipmentClassName) {
        this.equipmentManagementMapper.addEquipmentClassifications(equipmentClassName);
    }

    @Override
    public void updateEquipmentClassification(EquipmentClass equipmentClassName) {
        this.equipmentManagementMapper.updateEquipmentClassification(equipmentClassName);
    }

    @Override
    public void deleteEquipmentClassification(Integer id) {
        this.equipmentManagementMapper.deleteEquipmentClassification(id);
    }

    @Override
    public List<EquipmentName> equipmentclassificationDropList(String equipmentClassificationName) {
        List<EquipmentName> equipmentNames=this.equipmentManagementMapper.queryquipmentclassificationDropList(equipmentClassificationName);
        return equipmentNames;
    }

    @Override
    public void updateEquipmentclassification(EquipmentName equipmentName) {
        this.equipmentManagementMapper.updateEquipmentclassification(equipmentName);

    }

    @Override
    public void deleteEquipmentManagementByIds(List<EquipmentManagement> equipmentManagements) {
        this.equipmentManagementMapper.deleteEquipmentManagementByIds(equipmentManagements);
    }
}

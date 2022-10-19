package com.gxa.service;

import com.gxa.dto.EquipmentManagementDto;
import com.gxa.entity.*;

import java.util.List;

public interface EquipmentManagementService {
    List<EquipmentManagement> queryAll(EquipmentManagementDto equipmentManagementDto);
    Integer queryCount(EquipmentManagementDto equipmentManagementDto);
    List<EquipmentClass> queryEquipmentClass();
    List<EquipmentName> queryEquipmentName();
    List<Useunits> queryEquiUseunits();
    List<StorageLocation> queryEquipStorageLocation();
    void addEquipmentManagement(EquipmentManagementAU equipmentManagementAU);
    void updateEquipmentManagement(EquipmentManagementAU equipmentManagementAU);
    void deleteEquipmentManagement(Integer id);
    List<EquipmentList> querylistEquipmentone();
    List<MaintenanceRecords> querylistMaintenanceRecords();
    List<TechnicalData> querylistTechnicalData();
    List<EquipmentClassification> queryAllEquipmentClassifications();
    void addEquipmentClassification(EquipmentClass equipmentClassName);
    void updateEquipmentClassification(EquipmentClass equipmentClassName);
    void deleteEquipmentClassification(Integer id);
    List<EquipmentName> equipmentclassificationDropList(String equipmentClassificationName);
    void updateEquipmentclassification(EquipmentName equipmentName);
    void deleteEquipmentManagementByIds(List<Integer> ids);

}

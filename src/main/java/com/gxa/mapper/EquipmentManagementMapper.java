package com.gxa.mapper;

import com.gxa.dto.EquipmentManagementDto;
import com.gxa.entity.*;

import java.util.List;

public interface EquipmentManagementMapper {
    List<EquipmentManagement> queryAllEquipmentManagement(EquipmentManagementDto equipmentManagementDto);
    Integer queryConut(EquipmentManagementDto equipmentManagementDto);
    List<EquipmentClass> queryEquipmentClass();
    List<EquipmentName> queryEquipmentName();
    List<Useunits> queryEquipmentUseunits();
    List<StorageLocation> queryEquipStorageLocation();
    void addEquipmentManagement(EquipmentManagementAU equipmentManagementAU);
    void updateEquipmentManagement(EquipmentManagementAU equipmentManagementAU);
    void deleteEquipmentManagement(Integer id);
}
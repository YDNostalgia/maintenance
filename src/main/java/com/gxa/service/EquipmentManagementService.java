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

}

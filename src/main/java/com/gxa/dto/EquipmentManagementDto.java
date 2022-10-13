package com.gxa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EquipmentManagementDto {
    private Integer id;
    private Integer equipmentclassificationId;
    private String modalities;
    private String state;


}

package com.gxa.dto;

import lombok.Data;

@Data
public class EquipmentManagementDto {
    private Integer id;
    private Integer equipmentclassificationId;
    private String modalities;
    private String state;

    @Override
    public String toString() {
        return "EquipmentManagementDto{" +
                "id=" + id +
                ", equipmentclassification_id=" + equipmentclassificationId +
                ", modalities='" + modalities + '\'' +
                ", state=" + state +
                '}';
    }
}

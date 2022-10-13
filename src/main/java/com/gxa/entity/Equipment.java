package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("装备名称描述")
public class Equipment  {
    @ApiModelProperty(value = "装备ID",name = "equipmentName")
    private int id;
    @ApiModelProperty(value = "装备名称",name = "equipmentName")
    private String equipmentName;

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", equipmentName='" + equipmentName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
}

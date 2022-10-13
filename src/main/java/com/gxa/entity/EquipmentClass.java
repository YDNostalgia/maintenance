package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("装备类别实体")
public class EquipmentClass {
    @ApiModelProperty("装备类别id")
    private Integer id;
    @ApiModelProperty("装备类别名字")
    private String equipmentClassName;

    @Override
    public String toString() {
        return "EquipmentClass{" +
                "id=" + id +
                ", equipmentClassName='" + equipmentClassName + '\'' +
                '}';
    }
}

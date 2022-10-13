package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("装备名称")
public class EquipmentName {
    @ApiModelProperty("装备名称id")
    private Integer id;
    @ApiModelProperty("装备名称名字")
    private String equipName;
}
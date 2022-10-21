package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("装备分类_具体种类的下拉查询实体")
public class EquipmentNumber {
    @ApiModelProperty(value = "equipmentName",name = "器材名称")
    private String equipmentName;
    @ApiModelProperty(value = "number",name = "数量")
    private String number;
}

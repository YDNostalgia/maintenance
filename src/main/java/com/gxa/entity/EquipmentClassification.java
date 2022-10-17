package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("装备分类_数量实体")
public class EquipmentClassification {
    @ApiModelProperty("装备分类的名称")
    private String equipmentClassificationName;
    @ApiModelProperty("装备分类的数量")
    private Integer num;
}

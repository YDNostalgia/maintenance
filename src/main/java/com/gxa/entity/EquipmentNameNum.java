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
public class EquipmentNameNum {
 @ApiModelProperty("装备分类_具体种类的下拉查询名称")
    private String equipName;
    @ApiModelProperty("装备分类_具体种类的下拉查询数量")
    private Integer num;
}

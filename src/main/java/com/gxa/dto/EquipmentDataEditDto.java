package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("装备分类资料修改")
public class EquipmentDataEditDto {
    @ApiModelProperty(value = "类别id",name = "categoryId")
    private Integer categoryId;

    @ApiModelProperty(value = "类别名称",name = "categoryName")
    private String categoryName;
}

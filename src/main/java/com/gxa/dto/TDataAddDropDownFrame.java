package com.gxa.dto;

import com.gxa.entity.EquipmentData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "添加资料中资料类型的下拉列表")
public class TDataAddDropDownFrame {
    @ApiModelProperty(value = "资料类型",name = "categoryName")
    private String categoryName;
}

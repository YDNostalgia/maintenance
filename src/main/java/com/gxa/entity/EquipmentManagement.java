package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("返回的装备实体")
public class EquipmentManagement {
    @ApiModelProperty("装备编号")
    private Integer id;

    @ApiModelProperty("装备名称")
    private  EquipmentName equipmentName;

    @ApiModelProperty("装备分类")
    private  EquipmentClass equipmentClass;

    @ApiModelProperty("装备状态_ 0:正常  1：维修中  2:停用")
    private  Integer state;

    @ApiModelProperty("价格")
    private  String price;

    @ApiModelProperty("筹措方式状态_ 0:分配  1：自购 ")
    private  Integer modalities;

    @ApiModelProperty("使用单位")
    private  Useunits useunits;

    @ApiModelProperty("存放位置")
    private  StorageLocation storageLocation;

    @ApiModelProperty("责任人")
    private  String responsiblePerson;

}

package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("装备添加修改的实体")
public class EquipmentManagementAU {
    @ApiModelProperty("装备编号")
    private Integer id;

    @ApiModelProperty("装备名称")
    private  Integer equipmentNameId;

    @ApiModelProperty("装备分类")
    private  Integer equipmentClassId;

    @ApiModelProperty("装备状态_ 0:正常  1：维修中  2:停用")
    private  Integer state;

    @ApiModelProperty("价格")
    private  String price;

    @ApiModelProperty("筹措方式状态_ 0:全部  1：分配  2:自购")
    private  Integer modalities;

    @ApiModelProperty("使用单位")
    private  Integer useunitsId;

    @ApiModelProperty("存放位置")
    private  Integer storageLocationId;

    @ApiModelProperty("责任人")
    private  String responsiblePerson;

}

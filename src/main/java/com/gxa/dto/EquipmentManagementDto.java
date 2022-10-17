package com.gxa.dto;

import com.gxa.entity.EquipmentClass;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("装备查询的dto")
public class EquipmentManagementDto {
    @ApiModelProperty("条件查询_装备编号")
    private Integer id;
    @ApiModelProperty("条件查询_使用单位编号")
    private Integer useunitId;
    @ApiModelProperty("条件查询_装备分类编号")
    private Integer equipmentclassificationId;
    @ApiModelProperty("条件查询_筹措方式  0:分配 1:自购")
    private String modalities;
    @ApiModelProperty("条件查询_装备状态 0：正常 1:维修 2:停用")
    private Integer state;


}

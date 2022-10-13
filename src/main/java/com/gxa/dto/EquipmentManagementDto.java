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
    @ApiModelProperty("装备查询_装备编号")
    private Integer id;
    @ApiModelProperty("装备查询_使用仓库编号")
    private Integer useunitId;
    @ApiModelProperty("装备类别编号")
    private Integer equipmentclassificationId;
    @ApiModelProperty("装备筹措方式")
    private String modalities;
    @ApiModelProperty("装备状态")
    private String state;


}

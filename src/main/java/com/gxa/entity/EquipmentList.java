package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("装备管理_装备清单实体")
public class EquipmentList {
    @ApiModelProperty("装备清单id")
    private Integer id;
    @ApiModelProperty("装备清单_器材名称")
    private String equipmentName;
    @ApiModelProperty("装备清单_器材类型")
    private String equipmentClass;
    @ApiModelProperty("装备清单_是否维修 0:是 1:否")
    private Integer state;
}

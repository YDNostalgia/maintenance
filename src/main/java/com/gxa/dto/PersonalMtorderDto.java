package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("待维修任务搜索")
public class PersonalMtorderDto {

    @ApiModelProperty(value = "维修单号",name = "id")
    private Integer id;
    @ApiModelProperty(value = "装备名称",name = "equipmentName")
    private String equipmentName;
    @ApiModelProperty(value = "装备编号",name = "equipmentNumber")
    private Integer equipmentNumber;
}

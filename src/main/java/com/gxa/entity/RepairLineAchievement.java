package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "维修线绩效")
public class RepairLineAchievement {

    @ApiModelProperty(value = "维修部门的编号",name = "deptId")
    private Integer deptId; //维修部门的编号

    @ApiModelProperty(value = "维修部门的名称",name ="deptName")
    private String deptName; //维修部门的名称

    @ApiModelProperty(value = "维修部门的数量",name = "repairNums")
    private Integer repairNums; //维修数量
}

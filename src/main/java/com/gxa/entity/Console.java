package com.gxa.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("控制台实体")
public class Console {
    @ApiModelProperty("维修任务总量")
    private Integer maintenanceTotal;
    @ApiModelProperty("维修完成总量")
    private Integer maintenanceFinishTotal;
    @ApiModelProperty("维修未完成总量")
    private Integer maintenanceNotFinishTotal;
    @ApiModelProperty("维修人员数量")
    private Integer maintenancePersonnelTotal;
    @ApiModelProperty("维修总量实体")
    private List<RepairSituation> repairSituations;
    @ApiModelProperty("维修完成实体")
    private List<RepairCompleted> repairCompleted;

}

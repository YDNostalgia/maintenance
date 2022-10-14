package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("装备管理_维修记录实体")
public class MaintenanceRecords {
    @ApiModelProperty("维修记录id")
    private Integer id;
    @ApiModelProperty("维修记录_起始时间")
    private Date startTime;
    @ApiModelProperty("维修记录_结束时间")
    private Date endTime;
    @ApiModelProperty("维修记录_描述")
    private String desc;
}

package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("数据统计_维修量统计实体")
public class MaintenanceStatistics {
    @ApiModelProperty("维修名字")
    private String maintenanceName;
    @ApiModelProperty("月份")
    private Integer month;
    @ApiModelProperty("数量")
    private Integer num;

}

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
    @ApiModelProperty("一月")
    private Integer january;
    @ApiModelProperty("二月")
    private Integer february;
    @ApiModelProperty("三月")
    private Integer march;
    @ApiModelProperty("四月")
    private Integer april;
    @ApiModelProperty("五月")
    private Integer may;
    @ApiModelProperty("六月")
    private Integer june;
    @ApiModelProperty("七月")
    private Integer july;
    @ApiModelProperty("八月")
    private Integer august;
    @ApiModelProperty("九月")
    private Integer september;
    @ApiModelProperty("十月")
    private Integer october;
    @ApiModelProperty("十一月")
    private Integer november;
    @ApiModelProperty("十二月")
    private Integer december;
}

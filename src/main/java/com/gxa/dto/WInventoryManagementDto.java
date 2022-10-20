package com.gxa.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class WInventoryManagementDto {
    @ApiModelProperty(value = "条件查询_盘点单号",name = "inventory_No")
    private Integer inventoryNo;
    @ApiModelProperty(value = "条件查询_盘点日期",name = "startTime")
    private Date startTime;
    @ApiModelProperty(value = "条件查询_盘点日期",name = "endTime")
    private Date endTime;
    @ApiModelProperty(value = "条件查询_审核状态",name = "auditStatus")
    private Integer auditStatus;
}

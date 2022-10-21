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
@ApiModel("库存盘点")
public class WInventoryManagement {
    @ApiModelProperty(value = "盘点单号",name = "inventoryNo")
    private Integer inventoryNo;
    @ApiModelProperty(value = "盘点日期",name = "inventoryDate")
    private Date inventoryDate;
    @ApiModelProperty(value = "制单人",name = "preparedBy")
    private String preparedBy;
    @ApiModelProperty(value = "审核状态(0:待审核，1：审核通过，2，审核拒绝)",name = "auditStatus")
    private Integer auditStatus;
    @ApiModelProperty(value = "审核人",name = "reviewedBy")
    private String reviewedBy;
}

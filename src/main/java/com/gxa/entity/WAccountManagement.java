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
@ApiModel("台账管理")
public class WAccountManagement {
    @ApiModelProperty(value = "ID",name = "id")
    private Integer id;
    @ApiModelProperty(value = "入账日期",name = "entryDate")
    private Date entryDate;
    @ApiModelProperty(value = "批次号(入库单号)",name = "receiptNo")
    private Integer receiptNo;
    @ApiModelProperty(value = "器材",name = "wfacilityManagement")
    private WFacilityManagement wfacilityManagement;
    @ApiModelProperty(value = "数量",name = "quantity")
    private Integer quantity;
    @ApiModelProperty(value = "单价",name = "unitPrice")
    private double unitPrice;
}

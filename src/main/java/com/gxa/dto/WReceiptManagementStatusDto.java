package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("入库状态下拉列表")
public class WReceiptManagementStatusDto {
    @ApiModelProperty(value = "入库单号",name = "receiptNo")
    private Integer receiptNo;
    @ApiModelProperty(value = "审核状态(1.待审核，2.审核通过，3.审核拒绝)",name = "auditStatus")
    private Integer auditStatus;
}

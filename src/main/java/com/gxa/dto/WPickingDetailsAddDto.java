package com.gxa.dto;

import com.gxa.entity.WFacilityManagement;
import com.gxa.entity.WPickingDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "添加部门领料明细")
public class WPickingDetailsAddDto {
    @ApiModelProperty(value = "领料单号",name = "pickingNo")
    private Integer pickingNo;
    @ApiModelProperty(value = "批次号（入库单号）",name = "receiptNo")
    private Integer receiptNo;
    @ApiModelProperty(value = "器材编号",name = "wfacilityManagement")
    private Integer wfacilityManagementId;
    @ApiModelProperty(value = "数量",name = "quantity")
    private Integer quantity;
    @ApiModelProperty(value = "单价",name = "unitPrice")
    private double unitPrice;
}

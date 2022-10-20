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
@ApiModel("部门领料")
public class WPickingManagement {
    @ApiModelProperty(value = "领料单号",name = "pickingNo")
    private Integer pickingNo;
    @ApiModelProperty(value = "领料日期",name = "pickingDate")
    private Date pickingDate;
    @ApiModelProperty(value = "领料部门",name = "personalDept")
    private String personalDept;
    @ApiModelProperty(value = "制单人",name = "preparedBy")
    private String preparedBy;
    @ApiModelProperty(value = "审核状态(1:待审核，2：审核通过，3，审核拒绝)",name = "auditStatus")
    private Integer auditStatus;
    @ApiModelProperty(value = "审核人",name = "reviewedBy")
    private String reviewedBy;
}

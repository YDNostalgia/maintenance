package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "查询领料条件")
public class WPickingManagementQueryDto {
    @ApiModelProperty(value = "当前页", name = "page")
    private Integer page;
    @ApiModelProperty(value = "每页显示条数", name = "limit")
    private Integer limit;
    @ApiModelProperty(value = "开始时间", name = "startTime")
    private Date startTime;
    @ApiModelProperty(value = "结束时间", name = "endTime")
    private Date endTime;
    @ApiModelProperty (value = "部门ID",name = "pdeptId")
    private Integer pdeptId;
    @ApiModelProperty (value = "审核状态(1:待审核，2：审核通过，3，审核拒绝)",name = "auditStatus")
    private Integer auditStatus;
    @ApiModelProperty(value = "领料单号",name = "pickingNo")
    private Integer pickingNo;
}

package com.gxa.dto;

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
@ApiModel(value = "添加部门领料单")
public class WPickingManagementAddDto {
    @ApiModelProperty(value = "领料单号",name = "pickingNo")
    private Integer pickingNo;
    @ApiModelProperty(value = "领料日期",name = "pickingDate")
    private Date pickingDate;
    @ApiModelProperty(value = "领料部门ID",name = "personalDept")
    private Integer personalDeptId;
    @ApiModelProperty(value = "制单人ID",name = "preparedBy")
    private Integer preparedById;
    @ApiModelProperty(value = "领料明细",name = "wPickingDetails")
    private List<WPickingDetailsAddDto> wPickingDetailsAddDtos;
}

package com.gxa.dto;

import com.gxa.entity.Dreview;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@ApiModel("部门领料查询条件")
public class DpickingDto {

    @ApiModelProperty(value = "开始时间",name = "startTime")
    private Date startTime;
    @ApiModelProperty(value = "结束时间",name = "endTime")
    private Date endTime;
    @ApiModelProperty(value = "领料部门",name = "department")
    private String department;
    @ApiModelProperty(value = "领料单号",name = "code")
    private String code;
    @ApiModelProperty(value = "审核表状态",name = "dreview")
    private Dreview dreview;
}

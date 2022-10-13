package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data

@ApiModel("部门退料表")
public class DreturnDto {
    @ApiModelProperty(value = "退料表id",name = "id")
    private Integer id;
    @ApiModelProperty(value = "退料单号",name = "code")
    private String code;
    @ApiModelProperty(value = "退料部门",name = "department")
    private String department;
    @ApiModelProperty(value = "退料日期",name = "time")
    private Date time;
    @ApiModelProperty(value = "制表审核id",name = "reviewId")
    private Integer reviewId;
}

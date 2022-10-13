package com.gxa.dto;

import com.gxa.entity.Dreview;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("部门退料条件")
public class DreturnDto {
    @ApiModelProperty(value = "退料日期",name = "time")
    private Date time;
    @ApiModelProperty(value = "退料部门",name = "department")
    private String department;
    @ApiModelProperty(value = "制表审核",name = "dreview")
    private Dreview dreview;
    @ApiModelProperty(value = "退料单号",name = "code")
    private String code;
}

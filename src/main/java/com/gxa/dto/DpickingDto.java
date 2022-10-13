package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@ApiModel("部门领料表")
public class DpickingDto {
    @ApiModelProperty(value = "领料表id",name = "id")
    private Integer id;
    @ApiModelProperty(value = "领料单号",name = "code")
    private String code;
    @ApiModelProperty(value = "领料时间",name = "time")
    private Date time;
    @ApiModelProperty(value = "审核表id",name = "reviewId")
    private Integer reviewId;
}

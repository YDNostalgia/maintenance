package com.gxa.dto;

import com.gxa.entity.Dreview;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@ApiModel("盘点库存查询条件")
public class DcountingDto {

    @ApiModelProperty(value = "开始时间",name = "startTime")
    private Date startTime;
    @ApiModelProperty(value = "结束时间",name = "endTime")
    private Date endTime;
    @ApiModelProperty(value = "审核表状态",name = "dreview")
    private Dreview dreview;
    @ApiModelProperty(value = "盘点单号",name = "code")
    private String code;
    @ApiModelProperty(value ="当前页码" ,name ="page" )
    private Integer page;
    @ApiModelProperty(value ="每页记录数" ,name ="limit" )
    private Integer limit;
}

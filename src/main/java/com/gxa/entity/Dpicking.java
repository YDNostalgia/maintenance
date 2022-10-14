package com.gxa.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("部门领料表")
public class Dpicking {
    @ApiModelProperty(value = "领料表id",name = "id")
    private Integer id;
    @ApiModelProperty(value = "领料单号",name = "code")
    private String code;
    @ApiModelProperty(value = "领料部门",name = "department")
    private String department;
    @ApiModelProperty(value = "备份内容",name = "note")
    private String note;
    @ApiModelProperty(value = "领料时间",name = "time")
    private Date time;

    @ApiModelProperty(value = "审核表id",name = "dreview")
    private Dreview dreview;
    @ApiModelProperty(value = "器材表id",name = "dequip")
    private Dequip dequip;




}

package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.crypto.Data;
import java.util.Date;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("维修过程的实体")
public class RepairProcess {
    @ApiModelProperty("维修状态 2待维修   1维修中  3  维修完成")
    private Integer state;
    @ApiModelProperty("维修人名字")
    private String username;
    @ApiModelProperty("计划时间")
    private Date date;
    @ApiModelProperty("维修描述")
    private String desc;
    @ApiModelProperty("图片地址")
    private String imgsrc;
}

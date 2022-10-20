package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("维修记录--记录详情--维修过程 实体对应")
public class KeepProcess {
    @ApiModelProperty( "维修记录号")
    private int id;
    @ApiModelProperty("维修单号")
    private Integer keepId;
    @ApiModelProperty("创建时间")
    private Date creatTime;
    @ApiModelProperty("负责人(下拉框去人员找传id给我)")
    private Integer userId;
    @ApiModelProperty("维修状态   2待维修   1维修中  3  维修完成")
    private String states;
    @ApiModelProperty("图片地址")
    private String imgSrc;
    @ApiModelProperty("故障描述")
    private String desc;

    @ApiModelProperty("负责人实体")
    private PersonList personList;
}

package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("角色管理实体")
public class Role {

    private Integer id;
    @ApiModelProperty(value = "角色名", name = "roleName")
    private String roleName;
    @ApiModelProperty(value = "描述", name = "desc")
    private String desc;
    @ApiModelProperty(value = "人员数", name = "personnelNumber")
    private String personnelNumber;
    @ApiModelProperty(value = "添加时间", name = "addTime")
    private Date addTime;
    @ApiModelProperty(value = "状态", name = "state")
    private Integer state;
    @ApiModelProperty(value = "备注", name = "note")
    private String note;
}

package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("工种信息")
public class PersonalJob {
    @ApiModelProperty(value = "工种id",name = "id")
    private Integer pjobId;
    @ApiModelProperty(value = "工种",name = "pjob")
    private String pjob;

}

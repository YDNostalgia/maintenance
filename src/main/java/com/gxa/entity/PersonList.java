package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("维修记录--记录详情--维修过程 负责人对应")
public class PersonList {
    @ApiModelProperty("维修人ID")
    private int pid;
    @ApiModelProperty("维修人名字")
    private String pname;
}

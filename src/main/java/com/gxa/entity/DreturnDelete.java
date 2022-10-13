package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("部门领退料删除")
public class DreturnDelete {
    @ApiModelProperty(value = "退料编号集合",name = "code")
    private String code;
}

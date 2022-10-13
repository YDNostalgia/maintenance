package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("器材删除(多个)")
public class DreturnDeletes {
    @ApiModelProperty(value = "退料编号",name = "codes")
    private List<String> codes;
}

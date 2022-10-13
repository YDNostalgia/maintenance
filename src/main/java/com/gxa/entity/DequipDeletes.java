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
public class DequipDeletes {
    @ApiModelProperty(value = "器材编号",name = "code")
    private List<String> codes;
}

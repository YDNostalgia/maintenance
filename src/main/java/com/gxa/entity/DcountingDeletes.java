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
@ApiModel("库存盘点删除(多个)")
public class DcountingDeletes {
    @ApiModelProperty(value = "盘点单号",name = "codes")
    private List<String> codes;
}

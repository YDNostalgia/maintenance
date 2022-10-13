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
@ApiModel("入库管理删除(多个)")
public class DwarehouseDeletes {
    @ApiModelProperty(value = "入库单号",name = "codes")
    private List<String>  codes;
}

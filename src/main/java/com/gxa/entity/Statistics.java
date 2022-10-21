package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("维修统计的实体")
public class Statistics {
    private String deptName;
    private Integer month;
    private Integer price;
}

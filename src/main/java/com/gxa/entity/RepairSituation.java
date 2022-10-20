package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("维修总量实体")
public class RepairSituation {
    @ApiModelProperty("维修部门名称")
    private String deptName;
    @ApiModelProperty("维修总量")
    private Integer total;
}

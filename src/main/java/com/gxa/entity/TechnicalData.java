package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("装备管理_技术资料实体")
public class TechnicalData {
    @ApiModelProperty("技术资料_id")
    private Integer id;
    @ApiModelProperty("技术资料名字")
    private String profileName;
    @ApiModelProperty("装备类别")
    private String equipmentModel;
    @ApiModelProperty("技术资料描述")
    private String dataDesc;

}

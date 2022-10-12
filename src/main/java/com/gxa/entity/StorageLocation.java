package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("存放仓库")
public class StorageLocation {
    @ApiModelProperty("存放仓库id")
    private Integer id;
    @ApiModelProperty("存放仓库名称")
    private String storageLocationName;
}

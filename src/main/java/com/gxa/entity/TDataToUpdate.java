package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "修改资料")   //@ApiModel：用在返回对象类上，描述一个Model的信息（一般用在请求参数无法使用@ApiImplicitParam注解进行描述的时候）
public class TDataToUpdate {
    @ApiModelProperty(value = "资料id",name = "dataId")
    private Integer dataId;
    @ApiModelProperty(value = "资料名称",name = "dataName")
    private String dataName;

    @ApiModelProperty(value = "资料类型id",name = "categoryId")
    private Integer categoryId;

    @ApiModelProperty(value = "装备型号",name = "equipmentModel")
    private String equipmentModel;

    @ApiModelProperty(value = "资料说明",name = "dataDesc")
    private String dataDesc;

    @ApiModelProperty(value = "文件地址",name = "fileAddress")
    private String fileAddress;

    @ApiModelProperty(value = "文件上传时间",name = "fileUploadTime")
    private Date fileUploadTime;
}

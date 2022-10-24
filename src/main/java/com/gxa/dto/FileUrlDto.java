package com.gxa.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("图片回显地址")
public class FileUrlDto {

    @ApiModelProperty(value = "文件名", name = "fileName")
    private String fileName;
    @ApiModelProperty(value = "图片回显地址", name = "fileUrl")
    private String fileUrl;

}

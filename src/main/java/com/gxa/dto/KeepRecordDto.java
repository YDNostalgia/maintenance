package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("维护记录搜索信息")
public class KeepRecordDto {
    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty("搜索单号")
    private int id;
    @ApiModelProperty("维修状态 _ 2:待维修 1 :维修完成  0 ：维修中")
    private int testStatus;

    @Override
    public String toString() {
        return "keepRecordDto{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", id=" + id +
                ", testStatus=" + testStatus +
                '}';
    }
}

package com.gxa.dto;

import com.gxa.converter.DateConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("维护计划搜索信息")
public class KeepPlanDto {
    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty("搜索单号")
    private int id;

    @Override
    public String toString() {
        return "KeepPlanDto{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", id=" + id +
                '}';
    }
}

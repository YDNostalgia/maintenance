package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("考勤管理搜索")
public class PersonalAttendanceDto {
    @ApiModelProperty(value = "日期",name = "time")
    private Date time;
    @ApiModelProperty(value = "姓名",name = "pname")
    private String pname;
    @ApiModelProperty(value = "部门",name = "pdeptId")
    private String pdeptId;
    @ApiModelProperty(value = "考勤状态",name = "attendancezt")
    private Integer attendancezt;
}

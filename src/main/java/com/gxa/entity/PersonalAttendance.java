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
@ApiModel("考勤信息")
public class PersonalAttendance {
    @ApiModelProperty(value = "考勤人员编号")
    private Integer id;
    @ApiModelProperty(value = "姓名",name = "pname")
    private String pname;
    @ApiModelProperty(value = "签到时间",name = "signin")
    private Date signin;
    @ApiModelProperty(value = "签退时间",name = "signout")
    private Date signout;
    @ApiModelProperty(value = "考勤状态  1-正常，2-异常(迟到或早退)",name = "pstatus")
    private Integer pstatus;
    @ApiModelProperty(value = "人员信息",name = "personal")
    private Personal personal;

}

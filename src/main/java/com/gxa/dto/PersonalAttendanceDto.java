package com.gxa.dto;

import com.gxa.entity.PersonalDept;
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
    @ApiModelProperty(value = "当前页码",name = "page")
    private Integer page;
    @ApiModelProperty(value = "每页记录数",name = "limit")
    private Integer limit;
    @ApiModelProperty(value = "日期",name = "queryTime")
    private Date queryTime;
    @ApiModelProperty(value = "姓名",name = "pname")
    private String pname;
    @ApiModelProperty(value = "部门对象",name = "personalDept")
    private PersonalDept personalDept;
    @ApiModelProperty(value = "考勤状态  1-正常，2-异常(迟到或早退)",name = "pstatus")
    private Integer pstatus;
}

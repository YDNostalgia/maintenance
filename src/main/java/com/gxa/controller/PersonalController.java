package com.gxa.controller;

import com.gxa.dto.MtorderDto;
import com.gxa.dto.PersonalQueryDto;
import com.gxa.entity.Personal;
import com.gxa.entity.PersonalClass;
import com.gxa.entity.PersonalDept;
import com.gxa.entity.PersonalJob;
import com.gxa.service.PersonalService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(value = "人员信息")
@RestController
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @ApiOperation(value = "人员信息列表")
    @GetMapping(value = "/personal/list")
    public R personalList(@RequestBody(required = false) PersonalQueryDto personalQueryDto, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + personalQueryDto);
        System.out.println("当前页码-->" + page + ",每页记录数-->" + limit);

        List<Personal> personals = this.personalService.queryAllPersonal();
        System.out.println(personals);

        R r = new R();
        r.put("count",personals.size());
        r.put("data",personals);

        return r;
    }
    @ApiOperation(value = "部门下拉列表")
    @GetMapping(value = "/personal/pdept")
    public R personalDeptlist(){
        List<PersonalDept> personalDepts = this.personalService.queryAllPersonalDept();
        System.out.println(personalDepts);

        R r = new R();
        r.put("count",personalDepts.size());
        r.put("data",personalDepts);

        return r;
    }

    @ApiOperation(value = "工种下拉列表")
    @GetMapping(value = "/personal/pjob")
    public R personalJobList(){
        List<PersonalJob> personalJobs = this.personalService.queryAllPersonalJob();
        System.out.println(personalJobs);

        R r = new R();
        r.put("count",personalJobs.size());
        r.put("data",personalJobs);
        return r;
    }

    @PostMapping(value = "/personal/add")
    @ApiOperation(value = "添加人员")
    public R personalAdd(@RequestBody Personal personal){
        System.out.println(personal);

        //******
        R r = new R();
        return r;
    }

    @GetMapping(value = "/personal/pclass")
    @ApiOperation(value = "工种等级下拉列表")
    public R personClassList(){
        List<PersonalClass> personalClasses = this.personalService.queryAllPersonalClass();
        System.out.println(personalClasses);

        R r = new R();
        r.put("count",personalClasses.size());
        r.put("data",personalClasses);
        return r;
    }

    @GetMapping(value = "/personal/transfer")
    @ApiOperation(value = "人员抽组信息列表")
    public R personalTransferList(@RequestBody(required = false) Personal personal,Integer page,Integer limit){
        System.out.println(personal);
        System.out.println("当前页码-->" + page + ",每页记录数-->" + limit);

        List<Personal> personals = this.personalService.queryAllPersonal();
        R r = new R();
        r.put("count",personals.size());
        r.put("data",personals);
        return r;
    }

    @GetMapping(value = "/personalTransfer/next")
    @ApiOperation(value = "人员抽组下一步")
    public R personalTransferNext(){

        R r = new R();
        return r;
    }

    @GetMapping(value = "/mtorder/query")
    @ApiOperation(value = "待维修任务搜索")
    public R mtorderQuery(){

        R r = new R();
        return r;
    }

    @PostMapping(value = "/personalTransfer/save")
    @ApiOperation(value = "人员抽组提交")
    public R personalTransferSave(@RequestBody(required = false) MtorderDto mtorderDto){
        System.out.println(mtorderDto);

        R r = new R();
        return r;
    }

    @GetMapping(value = "/attendance/list")
    @ApiOperation(value = "考勤管理列表")
    public R attendanceList(){

        R r = new R();
        return r;
    }


}

package com.gxa.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.*;
import com.gxa.entity.*;
import com.gxa.service.PersonalService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "人员管理接口")
@RestController
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @ApiOperation(value = "人员信息列表")
    @PostMapping(value = "/personal/list")
    public Result<List<Personal>> personalList(@RequestBody(required = false) PersonalQueryDto personalQueryDto, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + personalQueryDto);
        System.out.println("当前页码-->" + page + ",每页记录数-->" + limit);
        //实现分页
        PageHelper.startPage(page,limit);

//        List<Personal> personals = this.personalService.queryAllPersonal();
        List<Personal> personals = this.personalService.queryAllPersonalList(personalQueryDto);
        System.out.println("查询记录数" + personals);

        //获取总记录条数
        PageInfo<Personal> pageInfo = new PageInfo<>(personals);
        Long total = pageInfo.getTotal();
        System.out.println("total-->" + total);

        Result<List<Personal>> resultPersonal = Result.success(personals,total);

        return resultPersonal;
    }
    @ApiOperation(value = "部门下拉列表")
    @GetMapping(value = "/personal/pdept")
    public Result<List<PersonalDept>> personalDeptlist(){
        List<PersonalDept> personalDepts = this.personalService.queryAllPersonalDept();
        System.out.println(personalDepts);

        Integer size = personalDepts.size();
        Long total = size.longValue();

        System.out.println("total-->" + total);

        Result<List<PersonalDept>> resultPersonalDept = Result.success(personalDepts,total);

        return resultPersonalDept;
    }

    @ApiOperation(value = "工种下拉列表")
    @GetMapping(value = "/personal/pjob")
    public Result<List<PersonalJob>> personalJobList(){
        List<PersonalJob> personalJobs = this.personalService.queryAllPersonalJob();
        System.out.println(personalJobs);

        Integer size = personalJobs.size();
        Long total = size.longValue();

        Result<List<PersonalJob>> resultPersonalJob = Result.success(personalJobs,total);

        return resultPersonalJob;
    }


    @GetMapping(value = "/personal/pclass")
    @ApiOperation(value = "工种等级下拉列表")
    public Result<List<PersonalClass>> personClassList(){
        List<PersonalClass> personalClasses = this.personalService.queryAllPersonalClass();
        System.out.println(personalClasses);

        Integer size = personalClasses.size();
        Long total = size.longValue();

        Result<List<PersonalClass>> resultPersonalClass = Result.success(personalClasses,total);

        return resultPersonalClass;
    }

    @PostMapping(value = "/personal/add")
    @ApiOperation(value = "添加人员")
    public R personalAdd(@RequestBody Personal personal){
        System.out.println(personal);

        Personal person = this.personalService.addPersonal(personal);

        if(person != null){
            R r = R.ok("人员信息添加成功！");
            return r;
        } else {
            R r = R.error(1, "人员信息添加失败,请重新发起请求！");
            return r;
        }
    }

    @GetMapping(value = "/personal/updatepre")
    @ApiOperation(value = "人员信息修改前数据回显")
    public R personalUpdatePre(Integer id){
        System.out.println(id);
        Personal personal = this.personalService.queryByPersonalId(id);

        R r = new R();
        r.put("data",personal);
        return r;
    }

    @PostMapping(value = "/personal/update")
    @ApiOperation(value = "人员信息修改提交")
    public R personalUpdate(@RequestBody Personal personal){
        System.out.println(personal);

        this.personalService.updatePersonal(personal);
        if(personal != null){
            R r = R.ok("人员信息修改成功！");
            return r;
        } else {
            R r = R.error(1, "人员信息修改失败,请重新发起请求！");
            return r;
        }
    }

    @GetMapping(value = "/personal/delete")
    @ApiOperation(value = "人员信息删除")
    public R personalDelete(Integer id){
        System.out.println(id);

        this.personalService.deletePersonal(id);
        if(id != null){
            R r = R.ok("人员信息删除成功！");
            return r;
        } else {
            R r = R.error(1, "人员信息删除失败,请重新发起请求！");
            return r;
        }
    }

    @PostMapping(value = "/personal/transfer")
    @ApiOperation(value = "人员抽组信息列表")
    public Result<List<Personal>> personalTransferList(@RequestBody(required = false) Personal personal,@Param("page") Integer page,@Param("limit") Integer limit){
        System.out.println(personal);
        System.out.println("当前页码-->" + page + ",每页记录数-->" + limit);

        PageHelper.startPage(page,limit);

        List<Personal> personals = this.personalService.queryAllPersonal();

        //获取总记录条数
        PageInfo<Personal> pageInfo = new PageInfo<>(personals);
        Long total = pageInfo.getTotal();

        Result<List<Personal>> resultPersonal = Result.success(personals,total);

        return resultPersonal;
    }

//    @GetMapping(value = "/personalTransfer/next")
//    @ApiOperation(value = "人员抽组下一步")
//    public R personalTransferNext(){
//
//        R r = new R();
//        return r;
//    }

    @PostMapping(value = "/mtorder/query")
    @ApiOperation(value = "待维修任务下一步，请求待维修任务列表+搜索")
    public Result<List<KeepRecord>> mtorderQuery(@RequestBody(required = false) PersonalMtorderDto personalMtorderDto,@Param("page") Integer page,@Param("limit") Integer limit){
        System.out.println("分页page：" + page + ".limit:" + limit);
        System.out.println("查询条件：" + personalMtorderDto);

        PageHelper.startPage(page,limit);
//        List<KeepRecord> keepRecords = this.personalService.queryAllKeeprecord();
        List<KeepRecord> keepRecords = this.personalService.queryAllKeeprecordList(personalMtorderDto);
        System.out.println("条件查询结果" + keepRecords);

        PageInfo<KeepRecord> pageInfo = new PageInfo<>(keepRecords);
        Long total = pageInfo.getTotal();
        System.out.println("total-->" + total);

        Result<List<KeepRecord>> resultKeepRecord = Result.success(keepRecords,total);

        return resultKeepRecord;
    }

    @PostMapping(value = "/personalTransfer/save")
    @ApiOperation(value = "人员抽组提交")
    public R personalTransferSave(@RequestBody(required = false) PersonSubmitMtorderDto personSubmitMtorderDto){
        System.out.println(personSubmitMtorderDto);


        //获取维修人员id
        List<Integer> personalId = personSubmitMtorderDto.getPersonalId();
        //获取待维修任务任务编号
        List<Integer> keepRecordId = personSubmitMtorderDto.getKeepRecordId();

        //判断业务逻辑，是否是一人多任务或者多人一任务，如果是多人多任务返回错误任务安排
        if((personalId.size() > 1)  && (keepRecordId.size() > 1) ){
            R r = R.error(1, "任务分配不符合业务逻辑，请选择一人完成多个任务，或者多人完成一个任务");
            return r;
        }

        R r = new R();
        return r;
    }

    @PostMapping(value = "/attendance/list")
    @ApiOperation(value = "考勤管理列表")
    public R attendanceList(@RequestBody(required = false) PersonalAttendanceDto personalAttendanceDto, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("条件查询信息：" + personalAttendanceDto);
        System.out.println("当前的时间为：" + personalAttendanceDto.getQueryTime());
        System.out.println("page:" + page + ",limit:" + limit);

        List<PersonalAttendance> personalAttendances = this.personalService.queryAllPersonalAttendance();
        System.out.println("人员考勤信息：" + personalAttendances);

        R r = new R();
        r.put("count",personalAttendances.size());
        r.put("data",personalAttendances);
        return r;
    }

    @PostMapping(value = "/mtorder/list")
    @ApiOperation(value = "维修工单")
    public R mtorderList(@RequestBody(required = false) PersonalMtorderListDto personalMtorderListDto,@Param("page") Integer page,@Param("limit") Integer limit){
        System.out.println(personalMtorderListDto);
        System.out.println("page:" + page + ",limit:" + limit);

        R r = new R();
        return r;
    }


}

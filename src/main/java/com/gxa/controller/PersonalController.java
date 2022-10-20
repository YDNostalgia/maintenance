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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Api(tags = "人员管理接口")
@RestController
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @ApiOperation(value = "人员信息列表")
    @PostMapping(value = "/personal/list")
    public Result<List<Personal>> personalList(@RequestBody(required = false) PersonalQueryDto personalQueryDto){
        System.out.println("查询条件" + personalQueryDto);
        Integer page = personalQueryDto.getPage();
        Integer limit = personalQueryDto.getLimit();
        System.out.println("当前页码-->" + page + ",每页记录数-->" + limit);

        Result<List<Personal>> resultPersonal = Result.failed("人员信息查询失败！");

        try {
            //实现分页
            PageHelper.startPage(page,limit);

            List<Personal> personals = this.personalService.queryAllPersonalList(personalQueryDto);
            System.out.println("查询记录数" + personals);

            //获取总记录条数
            PageInfo<Personal> pageInfo = new PageInfo<>(personals);
            Long total = pageInfo.getTotal();
            System.out.println("total-->" + total);
            resultPersonal = Result.success(personals,total);
            return resultPersonal;
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultPersonal;

    }
    @ApiOperation(value = "部门下拉列表")
    @GetMapping(value = "/personal/pdept")
    public Result<List<PersonalDept>> personalDeptlist(){

        Result<List<PersonalDept>> resultPersonalDept = Result.failed("部门信息拉取失败！");
        try {
            List<PersonalDept> personalDepts = this.personalService.queryAllPersonalDept();
            System.out.println(personalDepts);

            Integer size = personalDepts.size();
            Long total = size.longValue();

            System.out.println("total-->" + total);

            resultPersonalDept = Result.success(personalDepts,total);
        }catch (Exception e){
            e.printStackTrace();
        }

        return resultPersonalDept;
    }

    @ApiOperation(value = "工种下拉列表")
    @GetMapping(value = "/personal/pjob")
    public Result<List<PersonalJob>> personalJobList(){

        Result<List<PersonalJob>> resultPersonalJob = Result.failed("工种信息拉取失败！");
        try {
            List<PersonalJob> personalJobs = this.personalService.queryAllPersonalJob();
            System.out.println(personalJobs);

            Integer size = personalJobs.size();
            Long total = size.longValue();

            resultPersonalJob = Result.success(personalJobs,total);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultPersonalJob;
    }


    @GetMapping(value = "/personal/pclass")
    @ApiOperation(value = "工种等级下拉列表")
    public Result<List<PersonalClass>> personClassList(){

        Result<List<PersonalClass>> resultPersonalClass = Result.failed("工种等级信息拉取失败！");
        try {
            List<PersonalClass> personalClasses = this.personalService.queryAllPersonalClass();
            System.out.println(personalClasses);

            Integer size = personalClasses.size();
            Long total = size.longValue();

            resultPersonalClass = Result.success(personalClasses,total);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultPersonalClass;
    }

    @PostMapping(value = "/personal/add")
    @ApiOperation(value = "添加人员")
    public Result personalAdd(@RequestBody Personal personal){
        System.out.println(personal);

        Result resultPerson = Result.failed("人员信息添加失败！");
        try {
            Personal person = this.personalService.addPersonal(personal);
            resultPerson = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultPerson;
    }

    @GetMapping(value = "/personal/updatepre")
    @ApiOperation(value = "人员信息修改前数据回显")
    public R personalUpdatePre(Integer id){
        System.out.println(id);

        R r = new R();
        R.error(1,"人员信息修改前，数据回显失败！");
        try {
            Personal personal = this.personalService.queryByPersonalId(id);

            r.put("data",personal);
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @PostMapping(value = "/personal/update")
    @ApiOperation(value = "人员信息修改提交")
    public Result personalUpdate(@RequestBody Personal personal){
        System.out.println(personal);

        Result result = Result.failed("人员信息修改失败！");
        try {
            this.personalService.updatePersonal(personal);
            result = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/personal/delete")
    @ApiOperation(value = "人员信息删除")
    public Result personalDelete(Integer id){
        System.out.println(id);

        Result result = Result.failed("人员信息删除失败！");
        try {
            this.personalService.deletePersonal(id);
            result = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/personal/transfer")
    @ApiOperation(value = "人员抽组信息列表")
    public Result<List<Personal>> personalTransferList(@RequestBody(required = false) PersonalDto personalDto){
        System.out.println("人员抽组查询条件 ：" + personalDto);
        Integer page = personalDto.getPage();
        Integer limit = personalDto.getLimit();
        System.out.println("当前页码-->" + page + ",每页记录数-->" + limit);

        Result<List<Personal>> result = Result.failed("人员抽组信息列表拉取失败！");
        try {

            PageHelper.startPage(page,limit);

            List<Personal> personals = this.personalService.queryAllPersonalCzList(personalDto);

            //获取总记录条数
            PageInfo<Personal> pageInfo = new PageInfo<>(personals);
            Long total = pageInfo.getTotal();

            result = Result.success(personals,total);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @PostMapping(value = "/mtorder/query")
    @ApiOperation(value = "待维修任务下一步，请求待维修任务列表+搜索")
    public Result<List<KeepRecord>> mtorderQuery(@RequestBody(required = false) PersonalMtorderDto personalMtorderDto){
        System.out.println("查询条件：" + personalMtorderDto);
        Integer page = personalMtorderDto.getPage();
        Integer limit = personalMtorderDto.getLimit();
        System.out.println("分页page：" + page + ".limit:" + limit);

        Result<List<KeepRecord>> result = Result.failed("待维修任务列表拉取失败！");
        try {
            PageHelper.startPage(page,limit);

            List<KeepRecord> keepRecords = this.personalService.queryAllKeeprecordList(personalMtorderDto);
            System.out.println("条件查询结果" + keepRecords);

            PageInfo<KeepRecord> pageInfo = new PageInfo<>(keepRecords);
            Long total = pageInfo.getTotal();
            System.out.println("total-->" + total);

            result = Result.success(keepRecords,total);

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    @PostMapping(value = "/personalTransfer/save")
    @ApiOperation(value = "人员抽组提交")
    public R personalTransferSave(@RequestBody(required = false) PersonSubmitMtorderDto personSubmitMtorderDto){
        System.out.println("维修人员和待维修任务" + personSubmitMtorderDto);

        //获取维修人员id
        List<Integer> personalIds = personSubmitMtorderDto.getPersonalId();
        //获取待维修任务任务编号
        List<Integer> keepRecordIds = personSubmitMtorderDto.getKeepRecordId();

        //判断业务逻辑，是否是一人多任务或者多人一任务，如果是多人多任务返回错误任务安排
        if((personalIds.size() > 1)  && (keepRecordIds.size() > 1) ){
            R r = R.error(1, "任务分配不符合业务逻辑，请选择一人完成多个任务，或者多人完成一个任务");
            return r;
        }else {
            this.personalService.addPersonalSubmit(personalIds,keepRecordIds);

            R r = new R();
            return r;
        }
    }

    @PostMapping(value = "/attendance/list")
    @ApiOperation(value = "考勤管理列表")
    public Result<List<PersonalAttendance>> attendanceList(@RequestBody(required = false) PersonalAttendanceDto personalAttendanceDto){
        System.out.println("条件查询信息：" + personalAttendanceDto);
        //获取当前查询的时间
        Date queryTime = personalAttendanceDto.getQueryTime();
        Integer page = personalAttendanceDto.getPage();
        Integer limit = personalAttendanceDto.getLimit();
        System.out.println("当前的时间为：" + queryTime);
        System.out.println("page:" + page + ",limit:" + limit);

        Result<List<PersonalAttendance>> result = Result.failed("考勤管理列表信息拉取失败！");
        try {
            //实现分页
            PageHelper.startPage(page,limit);

            List<PersonalAttendance> personalAttendances = this.personalService.queryAllPersonalAttendanceList(personalAttendanceDto);

            System.out.println("人员考勤信息：" + personalAttendances);

            //获取条件查询总记录条数
            PageInfo<PersonalAttendance> pageInfo = new PageInfo<>(personalAttendances);
            long total = pageInfo.getTotal();

            result = Result.success(personalAttendances,total);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/mtorder/list")
    @ApiOperation(value = "维修工单")
    public Result<List<PersonalOrder>> mtorderList(@RequestBody(required = false) PersonalMtorderListDto personalMtorderListDto){
        System.out.println("维修工单查询条件：" + personalMtorderListDto);
        Integer page = personalMtorderListDto.getPage();
        Integer limit = personalMtorderListDto.getLimit();
        System.out.println("page:" + page + ",limit:" + limit);

        Result<List<PersonalOrder>> result = Result.failed("维修工单信息拉取失败！");
        try {
            //实现分页
            PageHelper.startPage(page,limit);

            List<PersonalOrder> personalOrders = this.personalService.queryAllPersonalOrderList(personalMtorderListDto);
            System.out.println("：维修工单列表：" + personalOrders);

            PageInfo<PersonalOrder> pageInfo = new PageInfo<>(personalOrders);
            long total = pageInfo.getTotal();

            result = Result.success(personalOrders,total);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }


}

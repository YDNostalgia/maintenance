package com.gxa.service;

import com.gxa.dto.*;
import com.gxa.entity.*;

import java.util.List;

public interface PersonalService {
    //拉去所有人员信息列表
    public List<Personal> queryAllPersonal();
    //部门下拉框拉去部门信息
    public List<PersonalDept> queryAllPersonalDept();
    //工种下拉框拉去工种信息
    public List<PersonalJob> queryAllPersonalJob();
    //工种等级下拉框拉去工种等级信息
    public List<PersonalClass> queryAllPersonalClass();
    //人员信息根据条件查询
    public List<Personal> queryAllPersonalList(PersonalQueryDto personalQueryDto);
    //添加人员信息
    public Personal addPersonal(Personal personal);
    //根据id查询该条记录人员信息，做修改界面数据回显
    public Personal queryByPersonalId(Integer id);
    //根据接收的Personal对象的id修改数据
    public void updatePersonal(Personal personal);
    //根据接收对象的id删除该条数据
    public void deletePersonal(Integer id);
    //人员抽组信息列表+条件查询
    public List<Personal> queryAllPersonalCzList(PersonalDto personalDto);
    //人员抽组待维修任务，获取所有的待维修的任务
    public List<KeepRecord> queryAllKeeprecord();
    //人员抽组待维修任务，根据条件查询待维修任务
    public List<KeepRecord> queryAllKeeprecordList(PersonalMtorderDto personalMtorderDto);
    //无条件拉取所有人员考勤信息
    public List<PersonalAttendance> queryAllPersonalAttendance();
    //按条件查询人员的考勤信息
    public List<PersonalAttendance> queryAllPersonalAttendanceList(PersonalAttendanceDto personalAttendanceDto);
    //将维修人员和维修任务的对应关系保存到数据库中
    public void addPersonalSubmit(List<Integer> personalIds,List<Integer> keepRecordIds);
    //拉取所有维修工单
    public List<PersonalOrder> queryAllPersonalOrder();
    //根据条件拉去维修工单
    public List<PersonalOrder> queryAllPersonalOrderList(PersonalMtorderListDto personalMtorderListDto);

}

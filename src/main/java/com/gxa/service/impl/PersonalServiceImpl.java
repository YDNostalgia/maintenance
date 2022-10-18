package com.gxa.service.impl;

import com.gxa.dto.PersonalAttendanceDto;
import com.gxa.dto.PersonalMtorderDto;
import com.gxa.dto.PersonalMtorderListDto;
import com.gxa.dto.PersonalQueryDto;
import com.gxa.entity.*;
import com.gxa.mapper.*;
import com.gxa.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private PersonalMapper personalMapper;

    @Autowired
    private PersonalDeptMapper personalDeptMapper;

    @Autowired
    private PersonalJobMapper personalJobMapper;

    @Autowired
    private PersonalClassMapper personalClassMapper;

    @Autowired
    private PersonalKeeprecordMapper personalKeeprecordMapper;

    @Autowired
    private PersonalAttendanceMapper personalAttendanceMapper;

    @Autowired
    private PersonalSubmitMapper personalSubmitMapper;

    @Autowired
    private PersonalOrderMapper personalOrderMapper;

    @Override
    public List<Personal> queryAllPersonal() {
        List<Personal> personals = this.personalMapper.queryAllPersonal();
        return personals;
    }
    @Override
    public List<Personal> queryAllPersonalList(PersonalQueryDto personalQueryDto) {
        List<Personal> personals = this.personalMapper.queryAllPersonalList(personalQueryDto);
        return personals;
    }

    @Override
    public List<PersonalDept> queryAllPersonalDept() {
        List<PersonalDept> personalDepts = this.personalDeptMapper.queryAllPersonalDept();
        return personalDepts;
    }

    @Override
    public List<PersonalJob> queryAllPersonalJob() {
        List<PersonalJob> personalJobs = this.personalJobMapper.queryAllPersonalJob();
        return personalJobs;
    }

    @Override
    public List<PersonalClass> queryAllPersonalClass() {
        List<PersonalClass> personalClasses = this.personalClassMapper.queryAllPersonalClass();
        return personalClasses;
    }

    @Override
    public Personal addPersonal(Personal personal) {
        this.personalMapper.addPersonal(personal);
        if (personal != null){
            return personal;
        }else {
            return null;
        }
    }

    @Override
    public Personal queryByPersonalId(Integer id) {
        Personal personal = this.personalMapper.queryByPersonalId(id);
        return personal;
    }

    @Override
    public void updatePersonal(Personal personal) {
        this.personalMapper.updatePersonal(personal);
    }

    @Override
    public void deletePersonal(Integer id) {
        this.personalMapper.deletePersonal(id);
    }

    @Override
    public List<KeepRecord> queryAllKeeprecord() {
        List<KeepRecord> keepRecords = this.personalKeeprecordMapper.queryAllKeeprecord();
        return keepRecords;
    }

    @Override
    public List<KeepRecord> queryAllKeeprecordList(PersonalMtorderDto personalMtorderDto) {
        List<KeepRecord> keepRecords = this.personalKeeprecordMapper.queryAllKeeprecordList(personalMtorderDto);
        return keepRecords;
    }

    @Override
    public List<PersonalAttendance> queryAllPersonalAttendance() {
        List<PersonalAttendance> personalAttendances = this.personalAttendanceMapper.queryAllPersonalAttendance();
//        System.out.println("service层输出考勤信息：" + personalAttendances);

        for(int i = 0;i < personalAttendances.size();i++){
            PersonalAttendance personalAttendance = personalAttendances.get(i);
            //获取签到时间的时
            int signinHours = personalAttendance.getSignin().getHours();
//            System.out.println(signinHours);
            //获取签退时间的时
            int signoutHours = personalAttendance.getSignout().getHours();
//            System.out.println(signoutHours);

            if(signinHours < 9 && signoutHours > 17){
                personalAttendance.setPstatus(0);
            }else if(signinHours > 8 || signoutHours < 18){
                personalAttendance.setPstatus(1);
            }

        }
        return personalAttendances;
    }

    @Override
    public List<PersonalAttendance> queryAllPersonalAttendanceList(PersonalAttendanceDto personalAttendanceDto) {
        List<PersonalAttendance> personalAttendances = this.personalAttendanceMapper.queryAllPersonalAttendanceList(personalAttendanceDto);

        //根据考勤状态查询
//        if(personalAttendanceDto.getPstatus() == 0){
//            for (int i = 0;i < personalAttendances.size();i++){
//                PersonalAttendance personalAttendance = personalAttendances.get(i);
//                if(personalAttendance.getPstatus() != 0){
//                    personalAttendances.remove(i);
//                    i--;
//                }
//            }
//        }else {
//            for (int i = 0;i < personalAttendances.size();i++){
//                PersonalAttendance personalAttendance = personalAttendances.get(i);
//                if(personalAttendance.getPstatus() == 0){
//                    personalAttendances.remove(i);
//                    i--;
//                }
//            }
//        }

        return personalAttendances;
    }

    @Override
    public void addPersonalSubmit(List<Integer> personalIds, List<Integer> keepRecordIds) {

        if(personalIds.size() == 1 && keepRecordIds.size() == 1){
            Integer personalId = personalIds.get(0);
            Integer keepRecordId = keepRecordIds.get(0);
            this.personalSubmitMapper.addPersonalSubmit(personalId,keepRecordId);
        }else if(personalIds.size() == 1 && keepRecordIds.size() > 1){
            Integer personalId = personalIds.get(0);
            for (int i = 0;i < keepRecordIds.size();i++){
                Integer keepRecordId = keepRecordIds.get(i);
                this.personalSubmitMapper.addPersonalSubmit(personalId,keepRecordId);
            }
        }else if(personalIds.size() > 1 && keepRecordIds.size() == 1){
            Integer keepRecordId = keepRecordIds.get(0);
            for(int i = 0;i < personalIds.size();i++){
                Integer personalId = personalIds.get(i);
                this.personalSubmitMapper.addPersonalSubmit(personalId,keepRecordId);
            }
        }
    }

    @Override
    public List<PersonalOrder> queryAllPersonalOrder() {
        List<PersonalOrder> personalOrders = this.personalOrderMapper.queryAllPersonalOrder();
        return personalOrders;
    }

    @Override
    public List<PersonalOrder> queryAllPersonalOrderList(PersonalMtorderListDto personalMtorderListDto) {
        if(personalMtorderListDto == null){
            PersonalMtorderListDto personalMtorderListDto01 = new PersonalMtorderListDto();

            personalMtorderListDto01.setPname(null);
            //获取当前的时间
            Date nowTime = new Date();
            System.out.println("当前的时间为： " + nowTime);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //创建Calendar实例
            Calendar calendar = Calendar.getInstance();

            //设置当前时间
            calendar.setTime(nowTime);
            //在当前时间减六天，获取当前时间一周的维修工单信息
            calendar.add(Calendar.DATE,-6);

            Date oldTime = calendar.getTime();
            System.out.println("减去6天的时间为：" + oldTime);

            //设置查询条件对象的时间值
            personalMtorderListDto01.setStartTime(nowTime);
            personalMtorderListDto01.setEndTime(oldTime);

            List<PersonalOrder> personalOrders = this.personalOrderMapper.queryAllPersonalOrderList(personalMtorderListDto01);
            System.out.println("service层输出查询结果：" + personalOrders);

            int orders = 0;
            for(int j = 0;j < personalOrders.size();j++){
                PersonalOrder personalOrder = personalOrders.get(j);
                Date startTime = personalOrder.getStartTime();
                String sformat = sdf.format(startTime);
                for(int i = 0;i <= 6;i++){
                    Calendar calendar01 = Calendar.getInstance();
                    calendar01.setTime(oldTime);
                    //在开始的第一天加上i天
                    calendar01.add(Calendar.DATE,i);

                    Date ctime = calendar01.getTime();
                    String cformat = sdf.format(ctime);
                    if(sformat.equals(cformat)){
                        Map<String, Integer> order = personalOrder.getOrder();
                        order.put(sformat,1);
                        orders++;
                    }else {
                        Map<String, Integer> order = personalOrder.getOrder();
                        order.put(sformat,0);
                    }
                }
            }

            return personalOrders;
        }else {
            List<PersonalOrder> personalOrders = this.personalOrderMapper.queryAllPersonalOrderList(personalMtorderListDto);
            return personalOrders;
        }
    }
}

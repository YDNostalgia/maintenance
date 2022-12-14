package com.gxa.service.impl;

import com.gxa.dto.*;
import com.gxa.entity.*;
import com.gxa.mapper.*;
import com.gxa.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

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
    public List<Personal> queryAllPersonalCzList(PersonalDto personalDto) {
        List<Personal> personals = this.personalMapper.queryAllPersonalCzList(personalDto);
        return personals;
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
//        System.out.println("service????????????????????????" + personalAttendances);

        for(int i = 0;i < personalAttendances.size();i++){
            PersonalAttendance personalAttendance = personalAttendances.get(i);
            //????????????????????????
            int signinHours = personalAttendance.getSignin().getHours();
//            System.out.println(signinHours);
            //????????????????????????
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

        //????????????????????????
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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(personalMtorderListDto.getPname() == null && personalMtorderListDto.getStartTime() == null && personalMtorderListDto.getEndTime() == null){
            PersonalMtorderListDto personalMtorderListDto01 = new PersonalMtorderListDto();

            personalMtorderListDto01.setPname(null);
            //?????????????????????
            Date nowTime = new Date();
            System.out.println("????????????????????? " + nowTime);

            //??????Calendar??????
            Calendar calendar = Calendar.getInstance();

            //??????????????????
            calendar.setTime(nowTime);
            //????????????????????????????????????????????????????????????????????????
            calendar.add(Calendar.DATE,-6);

            Date oldTime = calendar.getTime();
            System.out.println("??????6??????????????????" + oldTime);

            //????????????????????????????????????
            personalMtorderListDto01.setStartTime(oldTime);
            personalMtorderListDto01.setEndTime(nowTime);

            System.out.println("service???????????????personalMtorderListDto01???" + personalMtorderListDto01);

            //???????????????????????????????????????????????????????????????????????????
            List<PersonalOrder> personalOrdersIds = this.personalOrderMapper.queryIdAndOrders(personalMtorderListDto01);
            System.out.println("???????????????????????????" + personalOrdersIds);


            //??????????????????
            for(int j = 0;j < personalOrdersIds.size();j++){
                PersonalOrder personalOrder01 = personalOrdersIds.get(j);
                //????????????????????????map??????
                Map<String,Integer> map = new HashMap<>();

                //?????????????????????pname
                personalMtorderListDto01.setPname(personalOrder01.getPname());

                List<PersonalOrder> personalOrders = this.personalOrderMapper.queryAllPersonalOrderList(personalMtorderListDto01);
                System.out.println("service????????????????????????" + personalOrders);

                for(int i = 0;i <= 6;i++){
                    //?????????????????????????????????????????????
                    calendar.setTime(oldTime);
                    //???????????????????????????i???
                    calendar.add(Calendar.DATE,i);

                    Date ctime = calendar.getTime();
                    String cformat = sdf.format(ctime);
                    map.put(cformat,0);
                }

                personalOrder01.setOrder(map);

                for(int k = 0;k < personalOrders.size();k++){
                    PersonalOrder personalOrder = personalOrders.get(k);
                    Date startTime = personalOrder.getStartTime();
                    String sformat = sdf.format(startTime);


                    for(int i = 0;i <= 6;i++){
                        //?????????????????????????????????????????????
                        calendar.setTime(oldTime);
                        //???????????????????????????i???
                        calendar.add(Calendar.DATE,i);

                        Date ctime = calendar.getTime();
                        String cformat = sdf.format(ctime);


                        if(cformat.equals(sformat)){
                            map.put(cformat,map.get(cformat)+1);
                            personalOrder01.setOrder(map);

                        }
                    }
                }
            }
            return personalOrdersIds;

        }else {
            //?????????????????????????????????
            Date cstartTime = personalMtorderListDto.getStartTime();
            //?????????????????????????????????
            Date cendTime = personalMtorderListDto.getEndTime();
            //????????????????????????????????????????????????
            int days = (int)((cendTime.getTime() - cstartTime.getTime()) / (1000*3600*24));

            //??????Calendar??????
            Calendar calendar = Calendar.getInstance();

            //???????????????????????????????????????????????????????????????????????????
            List<PersonalOrder> personalOrdersIds = this.personalOrderMapper.queryIdAndOrders(personalMtorderListDto);
            System.out.println("???????????????????????????" + personalOrdersIds);


            //??????????????????
            for(int j = 0;j < personalOrdersIds.size();j++){
                PersonalOrder personalOrder01 = personalOrdersIds.get(j);
                //????????????????????????map??????
                Map<String,Integer> map = new HashMap<>();

                //?????????????????????pname
                personalMtorderListDto.setPname(personalOrder01.getPname());

                List<PersonalOrder> personalOrders = this.personalOrderMapper.queryAllPersonalOrderList(personalMtorderListDto);
                System.out.println("service????????????????????????" + personalOrders);

                for(int i = 0;i <= days;i++){
                    //?????????????????????????????????
                    calendar.setTime(cstartTime);
                    //???????????????????????????i???
                    calendar.add(Calendar.DATE,i);

                    Date ctime = calendar.getTime();
                    String cformat = sdf.format(ctime);
                    map.put(cformat,0);
                }

                personalOrder01.setOrder(map);

                for(int k = 0;k < personalOrders.size();k++){
                    PersonalOrder personalOrder = personalOrders.get(k);
                    Date startTime = personalOrder.getStartTime();
                    String sformat = sdf.format(startTime);


                    for(int i = 0;i <= days;i++){
                        //?????????????????????????????????
                        calendar.setTime(cstartTime);
                        //???????????????????????????i???
                        calendar.add(Calendar.DATE,i);

                        Date ctime = calendar.getTime();
                        String cformat = sdf.format(ctime);


                        if(cformat.equals(sformat)){
                            map.put(cformat,map.get(cformat)+1);
                            personalOrder01.setOrder(map);

                        }
                    }
                }
            }
            return personalOrdersIds;
        }
    }

}

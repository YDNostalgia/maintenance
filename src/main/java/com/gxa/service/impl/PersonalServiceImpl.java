package com.gxa.service.impl;

import com.gxa.dto.PersonalAttendanceDto;
import com.gxa.dto.PersonalMtorderDto;
import com.gxa.dto.PersonalQueryDto;
import com.gxa.entity.*;
import com.gxa.mapper.*;
import com.gxa.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

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
}

package com.gxa.service.impl;

import com.gxa.dto.PersonalQueryDto;
import com.gxa.entity.Personal;
import com.gxa.entity.PersonalClass;
import com.gxa.entity.PersonalDept;
import com.gxa.entity.PersonalJob;
import com.gxa.mapper.PersonalClassMapper;
import com.gxa.mapper.PersonalDeptMapper;
import com.gxa.mapper.PersonalJobMapper;
import com.gxa.mapper.PersonalMapper;
import com.gxa.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

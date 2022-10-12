package com.gxa.service.impl;

import com.gxa.entity.Personal;
import com.gxa.entity.PersonalDept;
import com.gxa.mapper.PersonalDeptMapper;
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

    @Override
    public List<Personal> queryAllPersonal() {
        List<Personal> personals = this.personalMapper.queryAllPersonal();
        return personals;
    }

    @Override
    public List<PersonalDept> queryAllPersonalDept() {
        List<PersonalDept> personalDepts = this.personalDeptMapper.queryAllPersonalDept();
        return personalDepts;
    }
}

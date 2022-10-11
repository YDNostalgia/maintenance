package com.gxa.service.impl;

import com.gxa.entity.Personal;
import com.gxa.mapper.PersonalMapper;
import com.gxa.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private PersonalMapper personalMapper;

    @Override
    public List<Personal> queryAll() {
        List<Personal> personals = this.personalMapper.queryAll();
        return personals;
    }
}

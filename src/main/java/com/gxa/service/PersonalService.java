package com.gxa.service;

import com.gxa.entity.Personal;
import com.gxa.entity.PersonalDept;

import java.util.List;

public interface PersonalService {
    public List<Personal> queryAllPersonal();
    public List<PersonalDept> queryAllPersonalDept();
}

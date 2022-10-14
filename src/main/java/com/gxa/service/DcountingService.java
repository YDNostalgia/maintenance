package com.gxa.service;

import com.gxa.entity.Dcounting;
import com.gxa.entity.Dreview;

import java.util.List;

public interface DcountingService {

    List<Dcounting> queryAll();

    List<Dreview> queryDreviews();
    void add(Dcounting dcounting);

    Dcounting queryById(Integer id);

    void update(Dcounting dcounting);

    void delete(Integer id);
}

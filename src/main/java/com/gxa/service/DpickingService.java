package com.gxa.service;

import com.gxa.entity.Dpicking;
import com.gxa.entity.Dreview;

import java.util.List;

public interface DpickingService {
    List<Dpicking> queryAll();
    List<Dreview> queryDreviews();
    void add(Dpicking dpicking);

    Dpicking queryById(Integer id);

    void update(Dpicking dpicking);

    void delete(Integer id);
}

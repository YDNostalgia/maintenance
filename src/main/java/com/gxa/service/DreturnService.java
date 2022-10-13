package com.gxa.service;

import com.gxa.entity.Dreturn;
import com.gxa.entity.Dreview;

import java.util.List;

public interface DreturnService {
    List<Dreturn> queryAll();
    List<Dreview> queryDreviews();

    void add(Dreturn dreturn);

    Dreturn queryById(Integer id);

    void update(Dreturn dreturn);

    void delete(Integer id);
}

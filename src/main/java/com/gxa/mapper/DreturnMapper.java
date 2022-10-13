package com.gxa.mapper;

import com.gxa.entity.Dreturn;

import java.util.List;

public interface DreturnMapper {
    List<Dreturn> queryAll();

    void save(Dreturn dreturn);
    Dreturn queryById(Integer id);

    void update(Dreturn dreturn);
    void delete(Integer id);
}

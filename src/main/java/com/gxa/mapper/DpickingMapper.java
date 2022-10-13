package com.gxa.mapper;

import com.gxa.entity.Dpicking;

import java.util.List;

public interface DpickingMapper {
    List<Dpicking> queryAll();
    void save(Dpicking dpicking);
    Dpicking queryById(Integer id);

    void update(Dpicking dpicking);
    void delete(Integer id);
}
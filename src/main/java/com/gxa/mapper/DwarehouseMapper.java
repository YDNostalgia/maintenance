package com.gxa.mapper;

import com.gxa.dto.DwarehouseDto;
import com.gxa.entity.Dequip;
import com.gxa.entity.Dreview;
import com.gxa.entity.Dwarehouse;

import java.util.List;

public interface DwarehouseMapper {
    List<Dwarehouse> queryDwarehouse(DwarehouseDto dwarehouseDto);
    List<Dreview> queryDreview(Dreview dreview);
    List<Dequip> queryDequip(Dequip dequip);
     void addDwarehouse(Dwarehouse dwarehouse);
     void updateDwarehouser(Dwarehouse dwarehouse);
     void deleteDwarehouse(Integer id);

}

package com.gxa.service;

import com.gxa.dto.DwarehouseDto;
import com.gxa.entity.Dequip;
import com.gxa.entity.Dreview;
import com.gxa.entity.Dwarehouse;
import com.gxa.entity.DwarehouseToAdd;

import java.util.List;

public interface DwarehouseService {
    List<Dwarehouse> queryDwarehouse(DwarehouseDto dwarehouseDto);

    List<Dreview> queryDreview(Dreview dreview);

//    List<Dequip> queryDequip(Dequip dequip);
//DequipToAdd addDequip(DequipToAdd dequipToAdd);
    DwarehouseToAdd addDwarehouse(DwarehouseToAdd dwarehouseToAdd);

    void updateDwarehouse(Dwarehouse dwarehouse);
    void deleteDwarehouse(Integer id);
    void addDequip(DwarehouseToAdd dwarehouseToAdd);
}

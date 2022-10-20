package com.gxa.mapper;

import com.gxa.entity.RepairCompleted;
import com.gxa.entity.RepairSituation;

import java.util.List;

public interface ConsoleMapper {
    Integer queryMaintenanceTotal();
    Integer queryMaintenanceFinishTotal();
    Integer queryMaintenanceNotFinishTotal();
    Integer queryMaintenancePersonnelTotal();
    List<RepairSituation> queryRepairSituation();
    List<RepairCompleted> queryRepairCompleted();
}

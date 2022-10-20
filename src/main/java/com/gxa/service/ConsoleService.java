package com.gxa.service;

import com.gxa.entity.RepairCompleted;
import com.gxa.entity.RepairSituation;

import java.util.List;

public interface ConsoleService {
    Integer queryMaintenanceTotal();
    Integer queryMaintenanceFinishTotal();
    Integer queryMaintenanceNotFinishTotal();
    Integer queryMaintenancePersonnelTotal();
    List<RepairSituation> queryRepairSituation();
    List<RepairCompleted> queryRepairCompleted();

}

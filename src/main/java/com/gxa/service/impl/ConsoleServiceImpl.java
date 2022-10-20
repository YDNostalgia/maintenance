package com.gxa.service.impl;

import com.gxa.entity.RepairCompleted;
import com.gxa.entity.RepairSituation;
import com.gxa.mapper.ConsoleMapper;
import com.gxa.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleServiceImpl implements ConsoleService {
    @Autowired
    private ConsoleMapper consoleMapper;
    @Override
    public Integer queryMaintenanceTotal() {
        Integer a=this.consoleMapper.queryMaintenanceTotal();
        return a;
    }

    @Override
    public Integer queryMaintenanceFinishTotal() {
        Integer b=this.consoleMapper.queryMaintenanceFinishTotal();
        return b;
    }

    @Override
    public Integer queryMaintenanceNotFinishTotal() {
        Integer c=this.consoleMapper.queryMaintenanceNotFinishTotal();
        return c;
    }

    @Override
    public Integer queryMaintenancePersonnelTotal() {
        Integer d=this.consoleMapper.queryMaintenancePersonnelTotal();
        return d;
    }

    @Override
    public List<RepairSituation> queryRepairSituation() {
        List<RepairSituation> repairSituations=this.consoleMapper.queryRepairSituation();
        return repairSituations;
    }

    @Override
    public List<RepairCompleted> queryRepairCompleted() {
        List<RepairCompleted> repairCompleteds=this.consoleMapper.queryRepairCompleted();
        return repairCompleteds;
    }
}

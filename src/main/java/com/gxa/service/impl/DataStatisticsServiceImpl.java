package com.gxa.service.impl;


import com.gxa.dto.BreakdownDto;
import com.gxa.entity.MaintenanceStatistics;
import com.gxa.mapper.DataStatisticsMapper;
import com.gxa.service.DataStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataStatisticsServiceImpl implements DataStatisticsService {
    @Autowired
    private DataStatisticsMapper dataStatisticsMapper;


    public List<BreakdownDto> queryBreakdown(BreakdownDto breakdownDto){
        List<BreakdownDto> breakdownDtos = this.dataStatisticsMapper.queryBreakdown(breakdownDto);
        return breakdownDtos;
    }


    @Override
    public List<MaintenanceStatistics> queryMaintenanceStatistic() {
        List<MaintenanceStatistics> maintenanceStatistics=this.dataStatisticsMapper.queryMaintenanceStatistics();
        return maintenanceStatistics;
    }

    @Override
    public List<MaintenanceStatistics> queryMaintenanceCosts() {
        List<MaintenanceStatistics> maintenanceStatistics=this.dataStatisticsMapper.queryMaintenanceCosts();
        return maintenanceStatistics;
    }


}

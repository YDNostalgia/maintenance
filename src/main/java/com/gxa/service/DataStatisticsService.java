package com.gxa.service;

import com.gxa.dto.BreakdownDto;
import com.gxa.entity.MaintenanceStatistics;

import java.util.List;

public interface DataStatisticsService {
    List<BreakdownDto> queryBreakdown(BreakdownDto breakdownDto);

    List<MaintenanceStatistics> queryMaintenanceStatistic();
    List<MaintenanceStatistics> queryMaintenanceCosts();
}

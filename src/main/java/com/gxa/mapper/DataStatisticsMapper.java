package com.gxa.mapper;

import com.gxa.dto.BreakdownDto;
import com.gxa.entity.MaintenanceStatistics;

import java.util.List;

public interface DataStatisticsMapper {
    List<BreakdownDto> queryBreakdown(BreakdownDto breakdownDto);

    List<MaintenanceStatistics> queryMaintenanceStatistics();
    List<MaintenanceStatistics> queryMaintenanceCosts();
}

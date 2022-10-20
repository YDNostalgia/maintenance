package com.gxa.mapper;

import com.gxa.dto.BreakdownDto;
import com.gxa.entity.MaintenanceStatistics;
import com.gxa.entity.Statistics;

import java.util.List;

public interface DataStatisticsMapper {
    List<BreakdownDto> queryBreakdown(BreakdownDto breakdownDto);

    List<MaintenanceStatistics> queryMaintenanceStatistics();

    List<Statistics> queryStatistics();
}

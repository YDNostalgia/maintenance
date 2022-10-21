package com.gxa.service;

import com.gxa.dto.BreakdownDto;
import com.gxa.entity.EquipmentNumber;
import com.gxa.entity.MaintenanceStatistics;
import com.gxa.entity.Statistics;

import java.util.List;

public interface DataStatisticsService {
    List<BreakdownDto> queryBreakdown(BreakdownDto breakdownDto);
    List<MaintenanceStatistics> queryMaintenanceStatistic();

    List<Statistics> queryStatistics();


    List<EquipmentNumber> queryEquipmentStatistics();
}

package com.gxa.controller;

import com.gxa.dto.BreakdownDto;
import com.gxa.entity.EquipmentNumber;
import com.gxa.entity.MaintenanceStatistics;
import com.gxa.entity.Statistics;
import com.gxa.service.DataStatisticsService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "数据统计")
@RestController
public class DataStatisticsController {
    @Autowired
    private DataStatisticsService dataStatisticsService;

    @PostMapping("/breakdown")
    @ApiOperation("装备故障统计")
    public Result<List<BreakdownDto>> breakdownList(@RequestBody(required = false) BreakdownDto breakdownDto){
      
        List<BreakdownDto> breakdownDtos = this.dataStatisticsService.queryBreakdown(breakdownDto);
        System.out.println("结果----->" + breakdownDtos);
        Result<List<BreakdownDto>> r = Result.success(breakdownDtos);
        return r;
    }

    @GetMapping("/equipmentNumber")
    @ApiOperation("器材调用统计")
    public Result<List<EquipmentNumber>> breakdownList(){

        List<EquipmentNumber> equipmentNumbers = this.dataStatisticsService.queryEquipmentStatistics();
        System.out.println("结果----->" + equipmentNumbers);
        Result<List<EquipmentNumber>> r = Result.success(equipmentNumbers);
        return r;
    }

    @GetMapping("/statistics/maintenance")
    @ApiOperation("数据统计接口_维修量统计")
    public Result<List<MaintenanceStatistics>> listMaintenance(){
        Result<List<MaintenanceStatistics>> r=Result.success();
        try {
            List<MaintenanceStatistics> maintenanceStatistics=this.dataStatisticsService.queryMaintenanceStatistic();
            r=Result.success(maintenanceStatistics);
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }

    @GetMapping("/statistics/maintenanceStatistics")
    @ApiOperation("数据统计接口_维修经费统计")
    public Result<List<Statistics>> listStatistics(){
        Result<List<Statistics>> r=Result.success();
        try {
            List<Statistics> statistics=this.dataStatisticsService.queryStatistics();
            r=Result.success(statistics);
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }
}

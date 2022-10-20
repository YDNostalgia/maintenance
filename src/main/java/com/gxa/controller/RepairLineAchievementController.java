package com.gxa.controller;

import com.gxa.entity.RepairLineAchievement;
import com.gxa.service.RepairLineAchievementService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "维修线绩效接口")
public class RepairLineAchievementController {

    @Autowired
    private RepairLineAchievementService repairLineAchievementService;

    @ApiOperation("维修线绩效查询")
    @GetMapping("/repairLineAchievement/list")
    public Result<List<RepairLineAchievement>> query(){
        Result<List<RepairLineAchievement>> r = Result.success();
        try {
            List<RepairLineAchievement> repairLineAchievements = repairLineAchievementService.query();
            r = Result.success(repairLineAchievements);

        }catch (Exception e){
            e.printStackTrace();
            Result.failed();
        }
        return r;
     }
}

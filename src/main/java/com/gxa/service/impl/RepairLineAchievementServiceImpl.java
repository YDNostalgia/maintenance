package com.gxa.service.impl;

import com.gxa.entity.RepairLineAchievement;
import com.gxa.mapper.RepairLineAchievementMapper;
import com.gxa.service.RepairLineAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RepairLineAchievementServiceImpl implements RepairLineAchievementService {

    @Autowired
    private RepairLineAchievementMapper repairLineAchievementMapper;

    @Override
    public List<RepairLineAchievement> query() {
        List<RepairLineAchievement> repairLineAchievements = repairLineAchievementMapper.query();
        return repairLineAchievements;
    }
}

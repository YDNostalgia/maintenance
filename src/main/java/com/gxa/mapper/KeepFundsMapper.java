package com.gxa.mapper;

import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepFunds;
import com.gxa.entity.KeepFundsAU;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface KeepFundsMapper {
    List<KeepFunds> queryAllKeepFunds(KeepPlanDto keepPlanDto);

    void addKeepFunds(KeepFundsAU keepFundsAU);
}

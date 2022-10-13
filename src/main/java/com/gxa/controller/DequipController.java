package com.gxa.controller;

import com.gxa.entity.Dequip;
import com.gxa.service.DequipService;
import com.gxa.utils.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "器材管理")
@RestController
public class DequipController {

    @Autowired
    private DequipService dequipService;

    @ApiOperation("器材管理列表")
    @GetMapping("/dequip/list")
    public TableResult selectDequip(){
        List<Dequip> dequips = this.dequipService.queryDequips();
        System.out.println(dequips);

        TableResult tableResult = new TableResult(0,"successful",dequips.size(),dequips);
        return tableResult;
    }
}

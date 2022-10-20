package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.WPickingDetailsAddDto;
import com.gxa.dto.WPickingManagementAddDto;
import com.gxa.dto.WPickingManagementQueryDto;
import com.gxa.dto.WPickingManagementUpdateDto;
import com.gxa.entity.StatuteType;
import com.gxa.entity.WPickingManagement;
import com.gxa.service.StatuteTypeService;
import com.gxa.service.WPickingManagementService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "部门领料")
public class WPickingManagementController {

    @Autowired
    private WPickingManagementService wPickingManagementService;
    @ApiOperation("查询部门领料单")
    @PostMapping("/WPickingManagement/list")
    public Result<List<WPickingManagement>> list(@RequestBody WPickingManagementQueryDto wPickingManagementQueryDto){

        Result<List<WPickingManagement>> r = Result.failed();
        PageInfo<WPickingManagement> pageInfo = wPickingManagementService.queryByCondition(wPickingManagementQueryDto);
        List<WPickingManagement> wPickingManagements = pageInfo.getList();
        long total = pageInfo.getTotal();

        if (wPickingManagements != null){
            r = Result.success(wPickingManagements,total);
            return r;
        }
        return r;
    }

    @ApiOperation("添加部门领料单")
    @PostMapping("/WPickingManagement/add")
    public Result add(@RequestBody WPickingManagementAddDto wPickingManagementAddDto){

        Result r = Result.failed();
        try {
            wPickingManagementService.add(wPickingManagementAddDto);
            r = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @ApiOperation("审核部门领料单")
    @PostMapping("/WPickingManagement/update")
    public Result  update(@RequestBody WPickingManagementUpdateDto wPickingManagementUpdateDto){

        Result r = Result.failed();
        try {
            wPickingManagementService.update(wPickingManagementUpdateDto);
            r = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

}

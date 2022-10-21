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
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "部门领料")
public class WPickingManagementController {

    @Autowired
    private WPickingManagementService wPickingManagementService;

    @ApiOperation("生成领料单号")
    @GetMapping("/WPickingManagement/addNo")
    public Result addNo(){

        Result r = Result.failed();
        try {
            Integer pickingNo = wPickingManagementService.addNo();
            r = Result.success(pickingNo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

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
    @PutMapping("/WPickingManagement/update")
    public Result  update(@RequestBody WPickingManagementUpdateDto wPickingManagementUpdateDto){

        Result r = Result.failed();
        try {
            String msg = wPickingManagementService.update(wPickingManagementUpdateDto);
            if ( msg.equals("审核成功")){
                r = Result.success();
                r.setMsg(msg);
            }else {
                r = Result.failed(msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @ApiOperation("删除部门领料单")
    @DeleteMapping("/WPickingManagement/delete")
    public Result  delete(@Param("pickingNo") Integer pickingNo){

        Result r = Result.failed();
        try {
            String msg = wPickingManagementService.delete(pickingNo);
            if ( msg.equals("删除成功")){
                r = Result.success();
                r.setMsg(msg);
            }else {
                r = Result.failed(msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

}

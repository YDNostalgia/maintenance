package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.StatuteAddDto;
import com.gxa.dto.StatuteEditDto;
import com.gxa.dto.StatuteQueryDto;
import com.gxa.entity.Statute;
import com.gxa.service.StatuteService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "法规")
public class StatuteController {

    @Autowired
    private StatuteService statuteService;
    @ApiOperation("查询法规")
    @PostMapping("/statute/list")
    public Result<List<Statute>> list(@RequestBody StatuteQueryDto statuteQueryDto){

        Result<List<Statute>> r = Result.failed("查询失败");
        try {
            PageInfo<Statute> pageInfo = this.statuteService.queryByIdAndName(statuteQueryDto);
            List<Statute> statutes = pageInfo.getList();
            long total = pageInfo.getTotal();
            r = Result.success(statutes,total);
            return r;
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @ApiOperation("添加法规")
    @PostMapping("/statute")
    public Result add(@RequestBody StatuteAddDto statuteAddDto){
        Result r = Result.failed("添加失败");
        try {
            statuteService.add(statuteAddDto);
            r = Result.success();
            return r;
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @ApiOperation("修改法规")
    @PutMapping("/statute")
    public Result update(@RequestBody StatuteEditDto statuteEditDto){
        Result r = Result.failed("修改失败");
        try {
            statuteService.update(statuteEditDto);
            r = Result.success();
            return r;
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

}

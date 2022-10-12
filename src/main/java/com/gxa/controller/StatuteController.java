package com.gxa.controller;

import com.gxa.dto.StatuteAddDto;
import com.gxa.dto.StatuteEditDto;
import com.gxa.dto.StatuteQueryDto;
import com.gxa.entity.Statute;
import com.gxa.service.StatuteService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("法规")
public class StatuteController {

    @Autowired
    private StatuteService statuteService;
    @ApiOperation("查询法规")
    @GetMapping("/statute/list")
    public R list(@RequestBody StatuteQueryDto statuteQueryDto){
        R r;
        Integer limit = statuteQueryDto.getLimit();
        Integer page = statuteQueryDto.getPage();
        List<Statute> statutes = this.statuteService.queryAll();

        if (statutes != null){
            r = R.ok();
            r.put("data",statutes);
            r.put("count",20);
            return r;
        }
        r = R.error(1,"查询失败");
        return r;
    }

    @ApiOperation("添加法规")
    @PostMapping("/statute")
    public R add(@RequestBody StatuteAddDto statuteAddDto){
        R r;
        r = R.error(1,"添加失败");
        r = R.ok("添加成功");
        return r;
    }

    @ApiOperation("修改法规")
    @PutMapping("/statute")
    public R edit(@RequestBody StatuteEditDto statuteEditDto){
        R r;
        r = R.error(1,"修改失败");
        r = R.ok("修改成功");
        return r;
    }

}

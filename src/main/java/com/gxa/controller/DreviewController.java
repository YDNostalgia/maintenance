package com.gxa.controller;

import com.gxa.dto.DreviewDto;
import com.gxa.entity.Dreview;
import com.gxa.service.DreviewService;
import com.gxa.utils.R;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DreviewController {

    @Autowired
    private DreviewService dreviewService;

    @ApiOperation(value = "审核信息表")
    @GetMapping("/dreview/list")
    public R selectDreview(@RequestBody(required = false) DreviewDto dreviewDto, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + dreviewDto);
        System.out.println("当前页码：" + page +",每页记录数：" + limit);

        List<Dreview> dreviews = this.dreviewService.queryAll();
        System.out.println(dreviews);

        R r = new R();
        r.put("count",dreviews.size());
        r.put("data",dreviews);

        return r;
    }

    @GetMapping("/dreview/perAdd")
    @ApiOperation("审核新增页")
    public R toAddPage(){
        R r = new R();
        return r;
    }
    @PostMapping("/dreview/add")
    @ApiOperation("审核新增")
    public R dreviewAdd(@RequestBody Dreview dreview){

        R r = new R();
        return r;
    }


    @GetMapping("/dreview/perEdit")
    @ApiOperation("审核修改页")
    public R toEditPage(){
        R r = new R();
        return r;
    }
    @PutMapping("/dreview/edit")
    @ApiOperation("审核修改")
    public R dreviewEdit(@RequestBody Integer code){

        R r = new R();
        return r;
    }

    @DeleteMapping("/dreview/delete")
    @ApiOperation("审核修改")
    public R dreviewDelete(@RequestBody Integer code){

        R r = new R();
        return r;
    }
    @DeleteMapping("/dreview/deletes")
    @ApiOperation("审核修改")
    public R dreviewDeletes(@RequestBody List<Integer> codes){

        R r = new R();
        return r;
    }
}

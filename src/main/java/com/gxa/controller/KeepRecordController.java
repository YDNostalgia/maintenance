package com.gxa.controller;

import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("维修记录接口")
public class KeepRecordController {
    @ApiOperation("维修记录查询")
    @GetMapping("keepRecord/queryAllRecord")
    public R queryAllRecord(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修记录添加")
    @PostMapping("keepRecord/addRecord")
    public R addRecord(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修记录修改")
    @PutMapping("keepRecord/updateRecord")
    public R updateRecord(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修记录删除")
    @DeleteMapping("keepRecord/deleteRecord")
    public R deleteRecord(){
        R r = new R();
        return r;
    }

    @RequestMapping("keepRecord/queryAllstatus")
    public R queryAllstatus(){
        R r = new R();
        return r;
    }
}

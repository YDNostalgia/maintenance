package com.gxa.controller;

import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("维修记录接口")
public class KeepRecordController {
    @ApiOperation("维修记录查询")
    @RequestMapping("keepRecord/queryAllRecord")
    public R queryAllRecord(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修记录添加")
    @RequestMapping("keepRecord/addRecord")
    public R addRecord(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修记录修改")
    @RequestMapping("keepRecord/updateRecord")
    public R updateRecord(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修记录删除")
    @RequestMapping("keepRecord/deleteRecord")
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

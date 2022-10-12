package com.gxa.controller;

import com.gxa.entity.Statute;
import com.gxa.service.StatuteService;
import com.gxa.utils.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatuteController {

    @Autowired
    private StatuteService statuteService;
    @PostMapping("/statute/list")
    public TableResult list(){
        TableResult tableResult = new TableResult(0,"查询失败",null,null);
        List<Statute> statutes = this.statuteService.queryAll();
        System.out.println("查询的数据" + statutes);

        if (statutes != null){
            tableResult.setCode(0);
            tableResult.setMsg("查询成功");
            tableResult.setData(statutes);
        }
        tableResult.setCode(1);
        return null;
    }

}

package com.gxa.controller;

import com.gxa.dto.StatuteDto;
import com.gxa.entity.Statute;
import com.gxa.service.StatuteService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Api("法规")
public class StatuteController {

    @Autowired
    private StatuteService statuteService;
    @ApiOperation("查询法规")
    @GetMapping("/statute")
    public R list(@RequestBody StatuteDto statuteDto){
        R r;
//        List<Statute> statutes = this.statuteService.queryAll();
        Integer limit = statuteDto.getLimit();
        Integer page = statuteDto.getPage();
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

}

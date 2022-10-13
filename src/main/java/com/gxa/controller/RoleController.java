package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.entity.Role;
import com.gxa.entity.User;
import com.gxa.service.UserService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "角色管理")
public class RoleController {
    @Autowired
    private UserService userService;

    @ApiOperation("角色列表")
    @GetMapping("/role/list")
    @ResponseBody
    public R list(Integer page, Integer limit){
        R r=null;
        PageHelper.startPage(page, limit);
        List<User> users = this.userService.queryAll();
        System.out.println("hgghhh----------"+users.get(1));
        PageInfo<User> pageInfo = new PageInfo<>(users);
        int total = (int) pageInfo.getTotal();
        System.out.println(total);
        r.setCount(total);
        r = R.ok();
        r.put("data",users);
        return r;
    }

    /**
     * 用户添加
     */
    @ApiOperation("角色添加")
    @GetMapping("/role/add")
    @ResponseBody
    public R add(@RequestBody Role role){
        return null;
    }

    /**
     * 用户修改
     */
    @ApiOperation("角色修改")
    @GetMapping("/role/update")
    @ResponseBody
    public R update(@RequestBody Role role){
        return null;
    }

    /**
     * 用户删除
     */
    @ApiOperation("角色删除")
    @GetMapping("/role/delete")
    @ResponseBody
    public R delete(@RequestBody List<Role> roles){
        return null;
    }

}

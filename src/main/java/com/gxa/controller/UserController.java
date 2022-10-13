package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.entity.User;
import com.gxa.service.UserService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Api(value = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user/login")
    @ApiOperation("用户登录")
    @ResponseBody
    /**
     * 用户登录
     */
    public String login(@RequestBody User user, HttpSession session){
        System.out.println(user);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPwd());

        try{

            subject.login(token);
            //登录成功

            return "redirect:/main.html";
        }catch (Exception e){
            e.printStackTrace();
            //登录失败
            return "redirect:/index.html";
        }
    }

    /**
     * 用户退出
     */

    @ApiOperation("用户退出")
    @GetMapping("/user/logout")
    @ResponseBody
    public String logout(HttpSession session){
        session.invalidate();

        return "redirect:/index.html";

    }


    /**
     * 用户列表
     */
    @ApiOperation("用户列表")
    @GetMapping("/user/list")
    @ResponseBody
    public R list(){
        R r=null;
//        PageHelper.startPage(page, limit);
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
    @ApiOperation("用户添加")
    @GetMapping("/user/add")
    @ResponseBody
    public R add(@RequestBody User user){
        return null;
    }

    /**
     * 用户修改
     */
    @ApiOperation("用户修改")
    @GetMapping("/user/update")
    @ResponseBody
    public R update(@RequestBody User user){
        return null;
    }

    /**
     * 用户删除
     */
    @ApiOperation("用户删除")
    @GetMapping("/user/delete")
    @ResponseBody
    public R delete(@RequestBody List<User> users){
        return null;
    }




}

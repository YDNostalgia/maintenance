package com.gxa.controller;

import com.gxa.entity.User;
import com.gxa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
@Api(value = "用户信息")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/login")
    @ApiOperation("用户列表")
    public String login(@RequestBody User user, HttpSession session){

        System.out.println(user);


        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPwd());
        Subject subject = SecurityUtils.getSubject();

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


    @GetMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();

        return "redirect:/index.html";

    }



}

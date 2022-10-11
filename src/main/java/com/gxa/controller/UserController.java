package com.gxa.controller;

import com.gxa.entity.User;
import com.gxa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Api(value = "用户信息")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    @ApiOperation("用户列表")
    public String login(User user, HttpSession session){

        System.out.println(user);


//       User u  = this.userService.login(user.getUserName(), user.getPwd());
//        if(u != null){
//            //登录成功 ，将用户信息放在session中
//            session.setAttribute("user",u);
//
//            return "redirect:/main.html";
//        }else{
//            return "redirect:/index.html";
//        }
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


    @GetMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();

        return "redirect:/index.html";

    }



}

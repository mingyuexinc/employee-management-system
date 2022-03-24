package com.kj.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @ApiOperation("登陆接口")
    @PostMapping("/login")
    public String Login(String username, String password, Model model, HttpSession httpSession){
        // 用户名密码判断
//        if (!StringUtils.isEmpty(username)&&password.equals("123456")){
//            httpSession.setAttribute("loginUser",username);
//            return "redirect:/main.html";
//        }else {
//            // 返回错误信息
//            model.addAttribute("msg","用户名或密码错误!");
//            return "index";
//        }
        // 获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        httpSession.setAttribute("username",username);
        try{
            // 执行登录方法
            subject.login(token);
            return "redirect:/main.html";
        }catch (UnknownAccountException e){  // 用户名不存在或者密码错误
            model.addAttribute("msg","用户名错误！");
            return "index";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误！");
            return "index";
        }
    }
    @ApiOperation("注销接口")
    @PostMapping("/loginOut")
    public String LoginOut(HttpSession httpSession){
        httpSession.invalidate(); // 移除session
        return "redirect:/index.html";
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String Unauthorized(){
        return "未经授权,无法访问此页面!";
    }
}

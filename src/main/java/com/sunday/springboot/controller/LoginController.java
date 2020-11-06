package com.sunday.springboot.controller;

import com.sunday.springboot.Service.LoginService;
import com.sunday.springboot.bean.LoginUser;
import com.sunday.springboot.bean.Result;
import com.sunday.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    //@PostMapping(value = "/login")
    //@ResponseBody
    //public Result login(@RequestBody LoginUser requestUser){
     //   return loginService.login(requestUser);
    //}


}

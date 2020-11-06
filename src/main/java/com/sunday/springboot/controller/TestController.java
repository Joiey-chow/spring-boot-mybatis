package com.sunday.springboot.controller;

import com.sunday.springboot.Dao.TestDao;
import com.sunday.springboot.Util.JwtUtil;
import com.sunday.springboot.bean.User;
import com.sunday.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    TestDao testDao;
    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody User sysUser){
        Map<String, Object> map = new HashMap<>();
        String username = sysUser.getName();
        String password = sysUser.getPwd();
        if(password.equals(testDao.GetTestDao(username))){
        String token = JwtUtil.sign(username,password);
        if (token != null){
            map.put("code", "200");
            map.put("message","认证成功");
            map.put("token", token);
            return map;
        }}
        map.put("code", "403");
        map.put("message","认证失败");
        return map;
    }
    @Autowired
    UserMapper userMapper;
   @PostMapping(value = "/api/test")//测试提取json数据
    public String get (@RequestBody  User getUser){//@RequestBody 让User类的getUser和接收的JSon数据映射
       User user=userMapper.getDeptByName(getUser.getName());
       System.out.println(user.getPwd());
       return user.getPwd();
   }

}

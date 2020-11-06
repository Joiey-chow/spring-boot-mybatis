package com.sunday.springboot.Service;

import com.sunday.springboot.bean.Result;
import com.sunday.springboot.bean.User;
import com.sunday.springboot.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;

@Service("insertService")
public class InsertService {
    @Resource
    private UserMapper userMapper;
    public Result insert(User insertUser) {
        String name = insertUser.getName();
        name = HtmlUtils.htmlEscape(name);
        String pwd = insertUser.getPwd();
        pwd = HtmlUtils.htmlEscape(pwd);
        userMapper.insertDept(name,pwd);
        return new Result(200);
    }
}

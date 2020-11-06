package com.sunday.springboot.Service;

import com.sunday.springboot.bean.Result;
import com.sunday.springboot.bean.User;
import com.sunday.springboot.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
@Service("updateService")
public class UpdateService {
    @Resource
    UserMapper userMapper;
    public Result update(User updateUser){
     Integer id=updateUser.getId();
     String name=updateUser.getName();
     String pwd=updateUser.getPwd();
     name= HtmlUtils.htmlEscape(name);
     pwd= HtmlUtils.htmlEscape(pwd);
     userMapper.updateUser(id,name,pwd);
     return new Result(200);
    }
}

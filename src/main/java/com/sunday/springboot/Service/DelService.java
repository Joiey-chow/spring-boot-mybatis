package com.sunday.springboot.Service;

import com.sunday.springboot.bean.Result;
import com.sunday.springboot.bean.User;
import com.sunday.springboot.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
@Service("deleteService")
public class DelService {
    @Resource
    UserMapper userMapper;
    public Result delete(User deleteUser){
        Integer id=deleteUser.getId();
        userMapper.deleteUser(id);
        return new Result(200);
    }
}

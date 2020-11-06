package com.sunday.springboot.Service;


import com.sunday.springboot.bean.LoginUser;
import com.sunday.springboot.bean.Result;
import com.sunday.springboot.bean.User;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Service("loginService")
public class LoginService {
    public Result login(LoginUser requestUser){
        String username=requestUser.getUsername();
        username= HtmlUtils.htmlEscape(username);
        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPwd())) {
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}

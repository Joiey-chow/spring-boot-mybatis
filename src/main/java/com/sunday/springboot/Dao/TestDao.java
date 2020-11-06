package com.sunday.springboot.Dao;

import com.sunday.springboot.bean.User;
import com.sunday.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public interface TestDao {
    public String GetTestDao(String name);
}



@Component
class TestDaoImpl implements  TestDao{
    @Autowired
    UserMapper userMapper;
    @Override
    public String GetTestDao(String name) {
        User user=userMapper.getDeptByName(name);
        return user.getPwd();
    }
}

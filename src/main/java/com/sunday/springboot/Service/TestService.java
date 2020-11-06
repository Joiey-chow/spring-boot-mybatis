package com.sunday.springboot.Service;
import com.sunday.springboot.Dao.TestDao;
import com.sunday.springboot.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService {
    @Resource
    UserMapper userMapper;
    @Autowired
    TestDao testDao;
    public String getPassword(String name){
        return testDao.GetTestDao(name);
    }

}

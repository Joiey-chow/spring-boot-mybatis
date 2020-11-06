package com.sunday.springboot.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sunday.springboot.Service.DelService;
import com.sunday.springboot.Service.InsertService;
import com.sunday.springboot.Service.UpdateService;
import com.sunday.springboot.bean.Department;
import com.sunday.springboot.bean.Employee;
import com.sunday.springboot.bean.Result;
import com.sunday.springboot.bean.User;
import com.sunday.springboot.mapper.DepartmentMapper;
import com.sunday.springboot.mapper.EmployeeMapper;
import com.sunday.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;
//    @MapperScan("mybatis.mapper.EmployeeMapper.xml")
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    InsertService insertService;

    @Autowired
    DelService delService;

    @Autowired
    UpdateService updateService;

    @PostMapping(value = "/update")
    @ResponseBody
    public Result update(@RequestBody User UpdateUser){return updateService.update(UpdateUser);}

    @PostMapping(value = "/del")
    @ResponseBody
    public Result delete(@RequestBody User id){return delService.delete(id);}

//从Mysql中查询所有用户数据的接口
    @ResponseBody
    @GetMapping("/findAll")
    public Map<String,Object> findAll(){
        Map<String,Object> map=new HashMap<>();
        List<User> results=userMapper.findAll();
        System.out.println(results);
        map.put("results",results);
        return map;
    }
    //插入
    @PostMapping(value = "/insert")
    @ResponseBody
    public Result insert(@RequestBody User InsertUser){return insertService.insert(InsertUser);}//与Mapper的void相对应返回

    //连接数据库匹配数据
    @GetMapping("/a/{id}")
    public User getUserID(@PathVariable("id") Integer id) {
        return userMapper.getDeptById(id);
    }

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }
    @GetMapping("/emp")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }

}

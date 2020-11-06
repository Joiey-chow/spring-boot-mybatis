package com.sunday.springboot.mapper;


import com.sunday.springboot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {


    Employee getEmByID(Integer id);
    void insertEmp(Employee employee);

    Employee getEmpById(Integer id);
}

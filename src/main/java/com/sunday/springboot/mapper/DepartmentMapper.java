package com.sunday.springboot.mapper;


import com.sunday.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {


    @Select("select * from Test1 where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from Test1 where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into Test1(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set Test1=#{departmentName} where id=#{id}")
    public int updateDept(Department department);

}

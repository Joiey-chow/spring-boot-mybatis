package com.sunday.springboot.mapper;
import com.sunday.springboot.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from test111 where id=#{id}")
    public User getDeptById(Integer id);


    @Select("select * from test111")
    List<User> findAll();

    @Insert("insert into test111(name,pwd) values(#{name},#{pwd})")
    void insertDept(String name, String pwd);

    @Delete("delete from test111 where id=#{id}")
    int deleteUser(Integer id);

    @Update("update test111 set name=#{name}, pwd=#{pwd} where id=#{id}")
    void updateUser(Integer id,String name, String pwd);

    @Select("select pwd from test111 where Name=#{name}")
     User getDeptByName(String name);


}

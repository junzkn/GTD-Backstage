package com.jun.mapper;


import com.jun.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> list();

    User find(@Param("name")String name, @Param("password")String password);

    void add(@Param("name")String name, @Param("password")String password);

    void update(@Param("name")String name, @Param("password")String password,@Param("repassword")String repassword);

    void delete(@Param("name")String name, @Param("password")String password);
}

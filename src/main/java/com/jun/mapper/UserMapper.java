package com.jun.mapper;


import com.jun.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> getUser();

    User checkUser(@Param("name")String name, @Param("password")String password);

    void addUser(@Param("name")String name, @Param("password")String password);

    void updateUser(@Param("name")String name, @Param("password")String password, @Param("repassword")String repassword);

    void deleteUser(@Param("id")String id);
}

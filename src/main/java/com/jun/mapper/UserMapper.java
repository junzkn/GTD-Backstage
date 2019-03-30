package com.jun.mapper;


import com.jun.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> list();

    User find(@Param("name")String corpId, @Param("password")String password);

}

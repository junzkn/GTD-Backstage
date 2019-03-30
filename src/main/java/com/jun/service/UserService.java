package com.jun.service;

import com.github.pagehelper.PageInfo;
import com.jun.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> list();

    User found(String name , String password) ;

    User add(String name , String password) ;

    User update(String name , String password,String repassword) ;

}

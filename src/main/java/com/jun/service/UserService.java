package com.jun.service;

import com.github.pagehelper.PageInfo;
import com.jun.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> list();

    User isExit(String name , String password) ;

}

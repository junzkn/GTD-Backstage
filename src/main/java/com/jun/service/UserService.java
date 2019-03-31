package com.jun.service;

import com.jun.pojo.User;

public interface UserService {


    User checkUser(String name , String password) ;

    User addUser(String name , String password) ;

    User updateUser(String name , String password, String repassword) ;


}

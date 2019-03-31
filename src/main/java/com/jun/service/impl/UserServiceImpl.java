package com.jun.service.impl;

import com.jun.mapper.TodoMapper;
import com.jun.mapper.UserMapper;
import com.jun.pojo.User;
import com.jun.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {
    @Resource private UserMapper userMapper ;
    @Resource private TodoMapper todoMapper ;


    @Override
    public User checkUser(String name, String password) {
        try{
            User user = userMapper.checkUser(name, password);
            return user ;
        }catch (Exception e){
            System.out.println(e.toString());
            return null ;
        }
    }

    @Override
    public User addUser(String name, String password) {
        try{
            userMapper.addUser(name,password) ;
            User user = userMapper.checkUser(name, password);
            return user ;
        }catch (Exception e){
            System.out.println(e.toString());
            return null ;
        }
    }

    @Override
    public User updateUser(String name, String password, String repassword) {
        try{
            userMapper.updateUser(name,password,repassword);
            User user = userMapper.checkUser(name, repassword);
            return user ;
        }catch (Exception e){
            System.out.println(e.toString());
            return null ;
        }
    }



}

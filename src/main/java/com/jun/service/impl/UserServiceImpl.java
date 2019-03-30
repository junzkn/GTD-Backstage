package com.jun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jun.mapper.UserMapper;
import com.jun.pojo.User;
import com.jun.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource UserMapper userMapper ;

    @Override
    public List<User> list() {
        try {
            return userMapper.list();
        }catch (Exception e){
            return null ;
        }
    }

    @Override
    public User found(String name, String password) {
        try{
            User user = userMapper.find(name, password);
            return user ;
        }catch (Exception e){
            System.out.println(e.toString());
            return null ;
        }
    }

    @Override
    public User add(String name, String password) {
        try{
            userMapper.add(name,password) ;
            User user = userMapper.find(name, password);
            return user ;
        }catch (Exception e){
            System.out.println(e.toString());
            return null ;
        }
    }

    @Override
    public User update(String name, String password, String repassword) {
        try{
            userMapper.update(name,password,repassword);
            User user = userMapper.find(name, repassword);
            return user ;
        }catch (Exception e){
            System.out.println(e.toString());
            return null ;
        }
    }


}

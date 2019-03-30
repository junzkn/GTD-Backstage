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
        return userMapper.list();
    }

    @Override
    public User isExit(String name, String password) {
        User user = userMapper.find(name, password);
        return user ;
    }


}

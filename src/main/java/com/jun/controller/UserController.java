package com.jun.controller;


import com.jun.pojo.ResponseData;
import com.jun.pojo.User;
import com.jun.service.UserService;
import com.jun.util.CookiesUtils;
import com.jun.util.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("user")
public class UserController {
    @Resource private UserService userService;


    @ResponseBody
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@RequestParam("name")String name, @RequestParam("password")String password,
                        HttpServletRequest request,HttpServletResponse response ) {
        User user = userService.found(name,password);
        ResponseData responseData = new ResponseData() ;
        responseData.setData(user);
        if(user!=null){
            responseData.setErrorCode(0);
            responseData.setErrorMsg("");
            CookiesUtils.addCookies(user.getName(),user.getPassword(),user.getId(),response);
        }
        else {
            responseData.setErrorCode(-1);
            responseData.setErrorMsg("账号密码不匹配");
            CookiesUtils.deleteCookies(request,response);
        }
        return JsonUtils.toJson(responseData) ;
    }



    @ResponseBody
    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        ResponseData responseData = new ResponseData() ;
        responseData.setData(null);
        responseData.setErrorCode(0);
        responseData.setErrorMsg("");
        CookiesUtils.deleteCookies(request,response);
        return JsonUtils.toJson(responseData) ;
    }


    @ResponseBody
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String register(@RequestParam("name")String name, @RequestParam("password")String password,
                           @RequestParam(value="repassword",required = false)String repassword,
                           HttpServletResponse response ) {
        User user ;
        if(repassword==null){
            user = userService.add(name,password);
        }else {
            user = userService.update(name,password,repassword);
        }
        ResponseData responseData = new ResponseData() ;
        responseData.setData(user);
        if(user!=null){
            responseData.setErrorCode(0);
            responseData.setErrorMsg("");
            CookiesUtils.addCookies(user.getName(),user.getPassword(),user.getId(),response);
        }
        else {
            responseData.setErrorCode(-1);
            responseData.setErrorMsg("该账号名字已注册");
        }
        return JsonUtils.toJson(responseData) ;

    }



    @ResponseBody
    @RequestMapping(value="/islogin", method=RequestMethod.GET)
    public String islogin(HttpServletRequest request) {
        return String.valueOf(CookiesUtils.isLogin(request)) ;
    }


}

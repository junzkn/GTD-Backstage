package com.jun.controller;


import com.jun.pojo.ResponseData;
import com.jun.pojo.User;
import com.jun.service.UserService;
import com.jun.util.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("user")
public class UserController {
    @Resource private UserService userService;


    @ResponseBody
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@RequestParam("name")String name, @RequestParam("password")String password,
                        HttpServletResponse response , HttpServletRequest request) {
        User user = userService.isExit(name,password);
        ResponseData responseData = new ResponseData() ;
        responseData.setData(user);
        if(user!=null){
            responseData.setErrorCode(0);
            responseData.setErrorMessage("");
            addCookies(user.getName(),user.getPassword(),user.getId(),response);
        }
        else {
            responseData.setErrorCode(-1);
            responseData.setErrorMessage("账号密码不匹配");
        }
        return JsonUtils.toJson(responseData) ;
    }



    @ResponseBody
    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        ResponseData responseData = new ResponseData() ;
        responseData.setData(null);
        responseData.setErrorCode(0);
        responseData.setErrorMessage("");
        deleteCookies(request,response);
        return JsonUtils.toJson(responseData) ;
    }


    @ResponseBody
    @RequestMapping(value="/isLogin", method=RequestMethod.GET)
    public String islogin(HttpServletRequest request) {
        return String.valueOf(isLogin(request)) ;
    }


    private void addCookies(String name, String password,int id,HttpServletResponse response) {
        Cookie cookieName = new Cookie("name",name) ;
        cookieName.setMaxAge(60);
        Cookie cookiePassword = new Cookie("password",password) ;
        cookiePassword.setMaxAge(60);
        Cookie cookieId = new Cookie("id",String.valueOf(id)) ;
        cookieId.setMaxAge(40);

        response.addCookie(cookieName);
        response.addCookie(cookiePassword);
        response.addCookie(cookieId);
    }



    private void deleteCookies(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("没有cookie");
        } else {
            for(Cookie cookie : cookies){
                //如果找到同名cookie，就将value设置为null，将存活时间设置为0，再替换掉原cookie，这样就相当于删除了。
                if(cookie.getName().equals("name") || cookie.getName().equals("password") || cookie.getName().equals("id")){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }


    private boolean isLogin(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            return false ;
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("id"))
                    return true ;
            }
        }
        return false ;
    }

}

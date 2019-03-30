package com.jun.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtils {

    private static final int cookiesAge = 10*60 ;



    public static  void addCookies(String name, String password,int id,HttpServletResponse response) {
        Cookie cookieName = new Cookie("name",name) ;
        cookieName.setMaxAge(cookiesAge);
        Cookie cookiePassword = new Cookie("password",password) ;
        cookiePassword.setMaxAge(cookiesAge);
        Cookie cookieId = new Cookie("id",String.valueOf(id)) ;
        cookieId.setMaxAge(cookiesAge);

        response.addCookie(cookieName);
        response.addCookie(cookiePassword);
        response.addCookie(cookieId);
    }



    public static  void deleteCookies(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (null!=cookies) {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("name") || cookie.getName().equals("password")
                        || cookie.getName().equals("id")){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }


    public static  boolean isLogin(HttpServletRequest request){
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

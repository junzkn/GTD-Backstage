package com.jun.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtils {

    private static final int cookiesAge = 100*60 ;



    public static void addCookies(String name, String password,int id,HttpServletResponse response) {
        Cookie cookieName = new Cookie("name",name) ;
        cookieName.setMaxAge(cookiesAge);
        cookieName.setPath("/");
        Cookie cookiePassword = new Cookie("password",password) ;
        cookiePassword.setMaxAge(cookiesAge);
        cookiePassword.setPath("/");
        Cookie cookieId = new Cookie("id",String.valueOf(id)) ;
        cookieId.setMaxAge(cookiesAge);
        cookieId.setPath("/");

        response.addCookie(cookieName);
        response.addCookie(cookiePassword);
        response.addCookie(cookieId);


    }



    public static void deleteCookies(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (null!=cookies) {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("name") || cookie.getName().equals("password")
                        || cookie.getName().equals("id")){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }
    }


    public static boolean checkLogin(HttpServletRequest request){
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


    public static int getUserId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id"))
                    return Integer.parseInt(cookie.getValue()) ;
            }
        }
        return -1;
    }


    public static void printCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                System.out.println("name:"+cookie.getName()+" and "+"value:"+cookie.getValue());
            }
        }
    }


}

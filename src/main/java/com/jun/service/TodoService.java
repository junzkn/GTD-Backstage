package com.jun.service;

import com.jun.pojo.ResponseData;
import com.jun.pojo.Todo;

import javax.servlet.http.HttpServletRequest;

public interface TodoService {


    int GET_BY_TYPE = 1001 ;
    int GET_BY_STATUS = 1002;
    int GET_ALL = 1003 ;


    ResponseData getTodo (HttpServletRequest request ,int symbol,int flag) ;

    ResponseData addTodo(HttpServletRequest request ,Todo todo) ;

    ResponseData updateTodo(HttpServletRequest request ,Todo todo) ;

    ResponseData updateTodoStatus(HttpServletRequest request ,int id , int flag) ;

    ResponseData deleteTodo(HttpServletRequest request , int id) ;

}

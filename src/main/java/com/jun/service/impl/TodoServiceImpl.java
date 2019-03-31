package com.jun.service.impl;

import com.jun.mapper.TodoMapper;
import com.jun.pojo.ResponseData;
import com.jun.pojo.Todo;
import com.jun.service.Common;
import com.jun.service.TodoService;
import com.jun.util.CookiesUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Resource private TodoMapper todoMapper ;

    @Override
    public ResponseData getTodo(HttpServletRequest request,int symbol, int flag) {
        ResponseData responseData = new ResponseData() ;
        if(CookiesUtils.checkLogin(request)){
            List<Todo> todos = new ArrayList<>() ;
            int userId = CookiesUtils.getUserId(request);
            try{
                switch (symbol) {
                    case TodoService.GET_BY_TYPE :
                        todos = todoMapper.getTodoByType(flag,userId) ;
                        break ;
                    case TodoService.GET_BY_STATUS:
                        todos = todoMapper.getTodoByStatus(flag,userId) ;
                        break ;
                    case TodoService.GET_ALL:
                        todos = todoMapper.getTodo(userId) ;
                        break ;
                }
                responseData.setErrorCode(Common.ERROR_CODE_R);
                responseData.setErrorMsg("");
            }catch (Exception e){
                responseData.setErrorCode(Common.ERROR_CODE_E);
                responseData.setErrorMsg("数据库出错");
            }
            responseData.setData(todos);
        }else {
            responseData.setErrorCode(Common.ERROR_CODE_E);
            responseData.setErrorMsg("请先登录");
            responseData.setData(null);
        }
        return  responseData ;
    }


    @Override
    public ResponseData addTodo(HttpServletRequest request ,Todo todo) {
        ResponseData responseData = new ResponseData() ;
        if(CookiesUtils.checkLogin(request)){
            int userId = CookiesUtils.getUserId(request);
            try{
                todoMapper.addTodo(todo);
                int id = todoMapper.findTheNewest();
                Todo newTodo = todoMapper.getTodoById(id,userId) ;
                responseData.setErrorCode(Common.ERROR_CODE_R);
                responseData.setErrorMsg("");
                responseData.setData(newTodo);
            }catch(Exception e){
                responseData.setErrorCode(Common.ERROR_CODE_E);
                responseData.setErrorMsg("数据库出错");
                responseData.setData(null);
            }
        }else {
            responseData.setErrorCode(Common.ERROR_CODE_E);
            responseData.setErrorMsg("请先登录");
            responseData.setData(null);
        }
        return responseData;
    }

    @Override
    public ResponseData updateTodo(HttpServletRequest request, Todo todo) {
        ResponseData responseData = new ResponseData() ;
        if(CookiesUtils.checkLogin(request)){
            int userId = CookiesUtils.getUserId(request);
            try{
                todoMapper.updateTodo(todo,userId);
                Todo newTodo = todoMapper.getTodoById(todo.getId(),userId) ;
                responseData.setErrorCode(Common.ERROR_CODE_R);
                responseData.setErrorMsg("");
                responseData.setData(newTodo);
            }catch(Exception e){
                responseData.setErrorCode(Common.ERROR_CODE_E);
                responseData.setErrorMsg("数据库出错");
                responseData.setData(null);
            }
        }else {
            responseData.setErrorCode(Common.ERROR_CODE_E);
            responseData.setErrorMsg("请先登录");
            responseData.setData(null);
        }
        return responseData;
    }

    @Override
    public ResponseData updateTodoStatus(HttpServletRequest request, int id ,int status) {
        ResponseData responseData = new ResponseData() ;
        if(CookiesUtils.checkLogin(request)){
            int userId = CookiesUtils.getUserId(request);
            try{
                todoMapper.updateTodoStatus(id,status,userId);
                Todo newTodo = todoMapper.getTodoById(id,userId) ;
                responseData.setErrorCode(Common.ERROR_CODE_R);
                responseData.setErrorMsg("");
                responseData.setData(newTodo);
            }catch(Exception e){
                responseData.setErrorCode(Common.ERROR_CODE_E);
                responseData.setErrorMsg("数据库出错");
                responseData.setData(null);
            }
        }else {
            responseData.setErrorCode(Common.ERROR_CODE_E);
            responseData.setErrorMsg("请先登录");
            responseData.setData(null);
        }
        return responseData;
    }


    @Override
    public ResponseData deleteTodo(HttpServletRequest request, int id) {
        ResponseData responseData = new ResponseData() ;
        if(CookiesUtils.checkLogin(request)){
            int userId = CookiesUtils.getUserId(request);
            try{
                todoMapper.deleteTodo(id,userId);
                responseData.setErrorCode(Common.ERROR_CODE_R);
                responseData.setErrorMsg("");
            }catch(Exception e){
                responseData.setErrorCode(Common.ERROR_CODE_E);
                responseData.setErrorMsg("数据库出错");
            }
        }else {
            responseData.setErrorCode(Common.ERROR_CODE_E);
            responseData.setErrorMsg("请先登录");
        }
        responseData.setData(null);
        return responseData;
    }
}

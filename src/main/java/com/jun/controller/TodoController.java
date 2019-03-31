package com.jun.controller;

import com.jun.pojo.ResponseData;
import com.jun.pojo.Todo;
import com.jun.service.TodoService;
import com.jun.util.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("todo")
public class TodoController {
    @Resource private TodoService todoService ;


    @ResponseBody
    @RequestMapping(value="/addTodo", method=RequestMethod.POST)
    public String addTodo(HttpServletRequest request ,@RequestBody Todo todo) {
        ResponseData responseData = todoService.addTodo(request, todo);
        return JsonUtils.toJson(responseData) ;
    }

    @ResponseBody
    @RequestMapping(value="/getTodo", method=RequestMethod.GET)
    public String getTodo(@RequestParam("symbol")int symbol, @RequestParam("flag")int flag, HttpServletRequest request) {
        ResponseData responseData = todoService.getTodo(request,symbol,flag);
        return JsonUtils.toJson(responseData) ;
    }

    @ResponseBody
    @RequestMapping(value="/deleteTodo", method=RequestMethod.POST)
    public String deleteTodo(@RequestParam("id")int id, HttpServletRequest request) {
        ResponseData responseData = todoService.deleteTodo(request,id);
        return JsonUtils.toJson(responseData) ;
    }

    @ResponseBody
    @RequestMapping(value="/updateTodo", method=RequestMethod.POST)
    public String updateTodo(@RequestBody Todo todo, HttpServletRequest request) {
        ResponseData responseData = todoService.updateTodo(request,todo);
        return JsonUtils.toJson(responseData) ;
    }

    @ResponseBody
    @RequestMapping(value="/updateTodoStatus", method=RequestMethod.POST)
    public String updateTodoStatus( @RequestParam("id")int id,  @RequestParam("status")int status,HttpServletRequest request) {
        ResponseData responseData = todoService.updateTodoStatus(request,id,status);
        return JsonUtils.toJson(responseData) ;
    }




}

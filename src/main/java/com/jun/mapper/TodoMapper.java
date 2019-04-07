package com.jun.mapper;

import com.jun.pojo.Todo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TodoMapper {

    List<Todo> getTodo(@Param("userid")int userid) ;

    List<Todo> getTodoByType(@Param("type")int type,@Param("userid")int userid) ;

    List<Todo> getTodoByStatus(@Param("type")int type,@Param("userid")int userid) ;

    Todo getTodoById(@Param("id")int id,@Param("userid")int userid) ;

    void addTodo(Todo todo) ;

    void updateTodo(Todo todo) ;

    void updateTodoStatus(@Param("id")int id,@Param("status")int status,@Param("userid")int userid) ;

    void deleteTodo(@Param("id")int id,@Param("userid")int userid) ;

    int findTheNewest() ;

}

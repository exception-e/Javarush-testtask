package com.study.dao;

import java.util.List;
import com.study.model.Todo;

public interface TodoDao {
    void addTodo(Todo var1);

    List<Todo> getAllTodos(String var1, int page) throws Exception;

    void deleteTodo(Integer var1);

    Todo updateTodo(Todo var1);

    Todo getTodo(int var1);

    int getCount();

    void setCount(String var1);
}

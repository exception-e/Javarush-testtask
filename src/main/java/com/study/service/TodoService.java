package com.study.service;

import java.util.List;
import com.study.model.Todo;

public interface TodoService {
    void addTodo(Todo var1);

    List<Todo> getAllTodos(String var1, int page) throws Exception;

    int getCount();

    void deleteTodo(Integer var1);

    Todo getTodo(int var1);

    Todo updateTodo(Todo var1);
}

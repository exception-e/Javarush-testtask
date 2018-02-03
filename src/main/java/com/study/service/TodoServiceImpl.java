package com.study.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.study.dao.TodoDao;
import com.study.model.Todo;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoDao todoDao;

    public TodoServiceImpl() {
    }

    @Transactional
    public void addTodo(Todo todo) {
        this.todoDao.addTodo(todo);
    }

    @Transactional
    public List<Todo> getAllTodos(String filter, int page) throws Exception {
        return this.todoDao.getAllTodos(filter, page);
    }

    @Transactional
    public int getCount(){
        return this.todoDao.getCount();
    }


    @Transactional
    public void deleteTodo(Integer todoId) {
        this.todoDao.deleteTodo(todoId);
    }

    public Todo getTodo(int todoid) {
        return this.todoDao.getTodo(todoid);
    }

    public Todo updateTodo(Todo todo) {
        return this.todoDao.updateTodo(todo);
    }
}
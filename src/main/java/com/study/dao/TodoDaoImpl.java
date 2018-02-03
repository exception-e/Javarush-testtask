package com.study.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.study.model.Todo;

@Repository
public class TodoDaoImpl implements TodoDao {
    @Autowired
    private SessionFactory sessionFactory;
    private int count;
    private int todosPerPage = 15;

    public TodoDaoImpl() {
    }

    public void addTodo(Todo todo) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(todo);
    }

    private Query getQuery(String filter) {
        Query query;
        if(filter.equals("Done")) {

            query = this.sessionFactory.getCurrentSession().createQuery("from Todo as Todo where Todo.done = ?");
            query.setBoolean(0, true);
        }

        else  if (filter.equals("NotDone"))
        {
            query = this.sessionFactory.getCurrentSession().createQuery("from Todo as Todo where Todo.done = ?");
            query.setBoolean(0,false);
        }

        else
            query = this.sessionFactory.getCurrentSession().createQuery("from Todo");

        return query;
    }

    public List<Todo> getAllTodos(String filter, int page){

        Query query = getQuery(filter);
        query.setFirstResult((page - 1) * todosPerPage);
        query.setMaxResults(todosPerPage);

        List<Todo> result = query.list();

        this.setCount(filter);

        return result;
    }

    public void setCount(String filter)
    {

        Query query = getQuery(filter);

        count = query.list().size();

    }

    public int getCount(){
        return count;
    }

    public void deleteTodo(Integer todoId) {
        Todo todo = this.sessionFactory.getCurrentSession().load(Todo.class, todoId);
        if (null != todo)
            this.sessionFactory.getCurrentSession().delete(todo);


    }

    public Todo getTodo(int todoid) {
        return (Todo)this.sessionFactory.getCurrentSession().get(Todo.class, todoid);
    }

    public Todo updateTodo(Todo todo) {
        this.sessionFactory.getCurrentSession().update(todo);
        return todo;
    }




}

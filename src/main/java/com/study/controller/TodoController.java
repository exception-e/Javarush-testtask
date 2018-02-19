package com.study.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.study.model.Todo;
import com.study.service.TodoService;

@Controller
public class TodoController {
    private static final Logger logger = Logger.getLogger(TodoController.class);
    @Autowired
    private TodoService TodoService;
    private int page = 1;
    private String filterValue = "All";

    public TodoController() {
        System.out.println("TodoController()");
    }

    @RequestMapping({"/mytodoapp"})
    public ModelAndView listTodo(ModelAndView model) throws Exception {
        System.out.println(filterValue);
        List<Todo> listTodo = this.TodoService.getAllTodos(filterValue, page);
        model.addObject("listTodo", listTodo);
        model.addObject("currentPage", page);
        model.addObject("filter", filterValue);
        model.addObject("count", TodoService.getCount()); //
        model.setViewName("home");
        return model;
    }

    @RequestMapping({"/mytodoapp/list"})

    public ModelAndView list(HttpServletRequest request, ModelAndView model) throws Exception {
        System.out.println(filterValue);
        List<Todo> listTodo = this.TodoService.getAllTodos(filterValue, page);
        model.addObject("count", TodoService.getCount());
        model.addObject("listTodo", listTodo);
        model.addObject("currentPage", page);
        model.setViewName("home");
        return model;
    }

    @RequestMapping({"/mytodoapp/listDone"})

    public ModelAndView listDone(ModelAndView model) throws Exception {
        List<Todo> listTodo = this.TodoService.getAllTodos("Done", page);
        model.addObject("count", TodoService.getCount());
        model.addObject("listTodo", listTodo);
        model.addObject("currentPage", page);
        model.setViewName("home");
        return model;
    }

    @RequestMapping({"/mytodoapp/listNotDone"})
    public ModelAndView listNotDone(ModelAndView model) throws Exception {
        List<Todo> listTodo = this.TodoService.getAllTodos("NotDone", page);
        model.addObject("count", TodoService.getCount());
        model.addObject("listTodo", listTodo);
        model.addObject("currentPage", page);
        model.setViewName("home");
        return model;
    }

    @RequestMapping({"/mytodoapp/listAll"})
    public ModelAndView listAll(ModelAndView model) throws Exception {
        List<Todo> listTodo = this.TodoService.getAllTodos("", page);
        model.addObject("listTodo", listTodo);
        model.addObject("count", TodoService.getCount());
        model.addObject("currentPage", page);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(
            value = {"/mytodoapp/newTodo"},
            method = {RequestMethod.GET}
    )
    public ModelAndView newTodo(ModelAndView model) {
        Todo todo = new Todo();
        model.addObject("Todo", todo);
        model.setViewName("TodoForm");
        return model;
    }

    @RequestMapping(
            value = {"/mytodoapp/saveTodo"},
            method = {RequestMethod.POST}
    )
    public ModelAndView saveTodo(@ModelAttribute Todo todo) {
        if (todo.getId() == 0) {
            this.TodoService.addTodo(todo);
        } else {
            this.TodoService.updateTodo(todo);
        }

        return new ModelAndView("redirect:/mytodoapp");
    }

    @RequestMapping(
            value = {"/mytodoapp/deleteTodo"},
            method = {RequestMethod.GET}
    )
    public ModelAndView deleteTodo(HttpServletRequest request) {
        int todoId = Integer.parseInt(request.getParameter("id"));
        this.TodoService.deleteTodo(todoId);
        return new ModelAndView("redirect:/mytodoapp");
    }

    @RequestMapping(
            value = {"/mytodoapp/editTodo"},
            method = {RequestMethod.GET}
    )
    public ModelAndView editTodo(HttpServletRequest request) {
        int todoId = Integer.parseInt(request.getParameter("id"));
        Todo todo = this.TodoService.getTodo(todoId);
        ModelAndView model = new ModelAndView("TodoForm");
        model.addObject("Todo", todo);
        return model;
    }

    @RequestMapping(
            value = {"/mytodoapp/paging"},
            method = {RequestMethod.GET}
    )
    public ModelAndView paging(HttpServletRequest request) {
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        page = pageNum;
        return new ModelAndView("redirect:/mytodoapp");
    }

    @RequestMapping(
            value = {"/mytodoapp/filter"},
            method = {RequestMethod.GET}
    )
    public ModelAndView filter(HttpServletRequest request) {
        String filter = request.getParameter("filter");
        filterValue = filter;
        return new ModelAndView("redirect:/mytodoapp");
    }
}
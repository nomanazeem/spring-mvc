package com.msna.springmvc;


import com.msna.model.Todo;
import com.msna.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("user")
public class TodoController {

    @Autowired
    private TodoService service;

    @RequestMapping(value = "/todo-list", method = RequestMethod.GET)
    public String TodoList(ModelMap modelMap) {
        String user=(String) modelMap.get("user");
        List<Todo> list = service.showAll(user);

        System.out.println("user::"+user);
        System.out.println("list::"+list);
        modelMap.put("user", user);
        modelMap.put("todoList", list);

        return "todo-list";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public String addTodo(){
        return "todo";
    }

    @RequestMapping(value="/add-todo", method=RequestMethod.POST)
    public String saveTodo(ModelMap modelMap, @RequestParam String desc, @RequestParam boolean isDone){
        String user = (String) modelMap.get("user");

        service.addTodo(user, desc, new Date(), isDone);

        modelMap.put("successMessage", "Todo has been added successfully.");


        return TodoList(modelMap);

    }
}

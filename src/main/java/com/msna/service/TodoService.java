package com.msna.service;

import com.msna.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todoList = new ArrayList<Todo>();
    private static int idCounter=0;

    static{

        todoList.add(new Todo(++idCounter,"azeem", "Todo 1", new Date(), true));
        todoList.add(new Todo(++idCounter,"azeem", "Todo 2", new Date(), false));
        todoList.add(new Todo(++idCounter,"azeem", "Todo 3", new Date(), true));
        todoList.add(new Todo(++idCounter,"azeem", "Todo 4", new Date(), false));
        todoList.add(new Todo(++idCounter,"saleem", "Todo 5", new Date(), false));
    }
    public Todo addTodo(String user, String desc, Date targetDate, boolean isDone){

        Todo todo = new Todo(++idCounter, user, desc, targetDate, isDone);
        todoList.add(todo);

        return todo;
    }
    public void removeTodo(int id) {
        Iterator<Todo> iterator = todoList.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
    public List<Todo> showAll(String user){
        List<Todo> filtered = new ArrayList<Todo>();

        for (Todo todo : todoList ){
            if(todo.getUser().equals(user)){
                filtered.add(todo);
            }
        }
        return filtered;
    }
}

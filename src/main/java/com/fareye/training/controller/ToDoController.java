package com.fareye.training.controller;

import com.fareye.training.model.ToDo;
import com.fareye.training.repository.ToDoRepository;
import com.fareye.training.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {
    static public List<ToDo> toDoList = new ArrayList<>();

    @Autowired
    ToDoService toDoService;
    @GetMapping("/get-todo")
    public List<ToDo>  getToDoList(@RequestParam Integer todoId){
        return toDoService.getAllToDos();
    }

    @PostMapping("/post-todo")
    public List<ToDo> createToDoList(@RequestBody @Valid ToDo toDo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException("invalid title for same user");
        }
        toDoService.addToDo(toDo);
        toDoList.add(toDo);
        System.out.println("Todo List added successfully!");
        return toDoList;
    }

    @PutMapping("/put-todo")
    public List<ToDo> putToDoList(@RequestBody ToDo todo){
        for(int i=0;i<toDoList.size();i++){
            if(todo.getUserId().equals(toDoList.get(i).getUserId())   &&   todo.getTitle().equals(toDoList.get(i).getTitle())){
                toDoList.set(i, todo);
                System.out.println("Successfully updated todoList!");
                break;
            }
        }
        return toDoList;
    }

    @DeleteMapping("/delete-todo")
    public List<ToDo> deleteToDoList(@RequestParam Integer userId, @RequestParam String title){
        for(int i=0;i<toDoList.size();i++){
            if(userId.equals(toDoList.get(i).getUserId())   &&   title.equals(toDoList.get(i).getTitle())){
                toDoList.remove(i);
                System.out.println("Successfully deleted todoList!");
                break;
            }
        }
        return toDoList;
    }
}

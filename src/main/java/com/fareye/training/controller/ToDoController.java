package com.fareye.training.controller;

import com.fareye.training.model.ToDo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {
    List<ToDo> toDoList = new ArrayList<>();

    @GetMapping("/get-todo")
    public List<ToDo>  getToDoList(@RequestParam String email){
        List<ToDo> toDoListUser = new ArrayList<>();
        for(int i=0;i<toDoList.size();i++){
            if(Objects.equals(toDoList.get(i).getUser().getEmail(), email)){
                toDoListUser.add(toDoList.get(i));
            }
        }
        return toDoListUser;
    }

    @PostMapping("/post-todo")
    public List<ToDo> createToDoList(@RequestBody @Valid ToDo toDo, BindingResult bindingResult){
        bindingResult.hasErrors();
        toDoList.add(toDo);
        System.out.println("Todo List added successfully!");
        return toDoList;
    }

    @PutMapping("/put-todo")
    public List<ToDo> putToDoList(@RequestBody ToDo todo){
        for(int i=0;i<toDoList.size();i++){
            if(todo.getUser().getEmail().equals(toDoList.get(i).getUser().getEmail())   &&   todo.getTitle().equals(toDoList.get(i).getTitle())){
                toDoList.set(i, todo);
                System.out.println("Successfully updated todoList!");
                break;
            }
        }
        return toDoList;
    }

    @DeleteMapping("/delete-todo")
    public List<ToDo> deleteToDoList(@RequestParam String email, @RequestParam String title){
        for(int i=0;i<toDoList.size();i++){
            if(email.equals(toDoList.get(i).getUser().getEmail())   &&   title.equals(toDoList.get(i).getTitle())){
                toDoList.remove(i);
                System.out.println("Successfully deleted todoList!");
                break;
            }
        }
        return toDoList;
    }
}

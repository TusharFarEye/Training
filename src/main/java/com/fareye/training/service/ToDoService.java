package com.fareye.training.service;

import com.fareye.training.model.ToDo;
import com.fareye.training.model.User;
import com.fareye.training.repository.ToDoRepository;
import com.fareye.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import java.util.Collections;
import java.util.List;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    @Autowired
    UserService userService;

    public void addToDo(ToDo toDo, String email){
        // adding foreign key {userId} ;
        toDo.setUserId(userService.getUserIdByUserEmail(email));
        toDoRepository.save(toDo);
    }

    public void deleteToDo(Integer toDoId){
        toDoRepository.deleteById(toDoId);
    }

    public List<ToDo> findUserByToDoId(Integer toDoId){
        return toDoRepository.findAllById(Collections.singleton(toDoId));
    }

    public List<ToDo> findAllTodosByUserId(Integer userId){
        return toDoRepository.findAllByUserId(userId);
    }

    public List<ToDo> getAllToDos(){
        return toDoRepository.findAll();
    }

    public Integer getUserIdByUserEmail(String email){
        return userService.getUserIdByUserEmail(email);
    }
}

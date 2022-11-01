package com.fareye.training.service;

import com.fareye.training.model.ToDo;
import com.fareye.training.model.User;
import com.fareye.training.repository.ToDoRepository;
import com.fareye.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    public void addToDo(ToDo toDo){
        toDoRepository.save(toDo);
    }

    public void deleteToDo(Integer toDoId){
        toDoRepository.deleteById(toDoId);
    }

    public List<ToDo> findUserByToDoId(Integer toDoId){
        return toDoRepository.findAllById(Collections.singleton(toDoId));
    }

    public List<ToDo> getAllToDos(){
        return toDoRepository.findAll();
    }
}

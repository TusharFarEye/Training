package com.fareye.training.annotation;

import com.fareye.training.annotation.DuplicateTitle;
import com.fareye.training.controller.ToDoController;
import com.fareye.training.model.ToDo;
import com.fareye.training.model.User;
import com.fareye.training.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class AnnotationValidator implements ConstraintValidator<DuplicateTitle, ToDo> {
    @Autowired
    ToDo Todo;

    @Autowired
    ToDoService toDoService;

    public boolean isValid(ToDo todo, ConstraintValidatorContext constraintValidatorContext){

        List<ToDo>list = toDoService.getAllToDos();
        if(list!=null && list.size()!=0){
            for (ToDo t:list){
                if (t.getTitle().equals(todo.getTitle()))
                    return false;
            }
        }
        return true;
    }
}
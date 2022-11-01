//package com.fareye.training.annotations;
//
//import com.fareye.training.annotation.DuplicateTitle;
//import com.fareye.training.controller.ToDoController;
//import com.fareye.training.model.ToDo;
//import com.fareye.training.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//import java.util.List;
//
//public class AnnotationValidator implements ConstraintValidator<DuplicateTitle, ToDo> {
//    @Autowired
//    ToDo Todo;
//
//    public boolean isValid(ToDo todo, ConstraintValidatorContext constraintValidatorContext){
//
//        List<ToDo>list = ToDoController.toDoList;
//        if(list!=null && list.size()!=0){
//            for (ToDo t:list){
//                if (t.getTitle().equals(todo.getTitle()))
//                    return false;
//            }
//        }
//        return true;
//    }
//}
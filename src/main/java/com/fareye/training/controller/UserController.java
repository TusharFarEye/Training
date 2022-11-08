package com.fareye.training.controller;

import com.fareye.training.model.User;
import com.fareye.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    static List<User> users = new ArrayList<User>();
    @Autowired
    UserService userService;

    @GetMapping("/get-user")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/post-user")
    public User createUser(@RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException("illegal arguments");
        }
        users.add(user);
        userService.addUser(user);
        System.out.println("User added successfully!");
        return user;
    }

    @PutMapping("/put-user")
    public List<User> putUser(@RequestBody User user){
        for(int i=0;i<users.size();i++){
            if(user.getId().equals(users.get(i).getId())){
                users.set(i, user);
                System.out.println("User updated successfully!");
                break;
            }
        }
        return users;
    }

    @DeleteMapping("/delete-user")
    public List<User> deleteUser(@RequestParam Integer userId){
        System.out.println("delete request successfull!");

        userService.deleteUser(userId);

//        for(int i=0;i<users.size();i++){
//            if(Objects.equals(userId, users.get(i).getId())){
//                users.remove(i);
//                System.out.println("User removed successfully!");
//                break;
//            }
//        }
//        System.out.println("no of users present :" + users.size());
        return users;
    }

}

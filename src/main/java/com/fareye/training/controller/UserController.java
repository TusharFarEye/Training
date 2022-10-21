package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    List<User> users = new ArrayList<User>();

    @GetMapping("/get-user")
    public List<User> getUser(){
//        String email = user.getEmail();
//        User currUser = new User();
//        for(int i=0;i<users.size();i++){
//            if(email.equals(users.get(i).getEmail())){
//                currUser = users.get(i);
//            }
//        }
        return users;
    }

    @PostMapping("/post-user")
    public User createUser(@RequestBody User user){
        users.add(user);
        System.out.println("User added successfully!");
        return user;
    }

    @PutMapping("/put-user")
    public List<User> putUser(@RequestBody User user){
        for(int i=0;i<users.size();i++){
            if(user.getEmail().equals(users.get(i).getEmail())){
                users.set(i, user);
                System.out.println("User updated successfully!");
                break;
            }
        }
        return users;
    }

    @DeleteMapping("/delete-user")
    public List<User> deleteUser(@RequestParam String email){
        System.out.println("delete request successfull!");
        for(int i=0;i<users.size();i++){
            if(Objects.equals(email, users.get(i).getEmail())){
                users.remove(i);
                System.out.println("User removed successfully!");
                break;
            }
        }
        System.out.println(users.size());
        return users;
    }

}

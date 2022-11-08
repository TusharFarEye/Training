package com.fareye.training.service;

import com.fareye.training.model.User;
import com.fareye.training.repository.UserRepository;
import com.fareye.training.utility.EncodePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    @Autowired
    EncodePassword encodePassword;
    @Autowired
    UserRepository userRepository;

    public void addUser(User user){
        User userWithHashedPassword = user;
        userWithHashedPassword.setPassword(getHashedPassword(user.getPassword()));
        userRepository.save(userWithHashedPassword);
    }

    public Integer getUserIdByUserEmail(String email) throws UsernameNotFoundException {
        List<User> userList= findUserByEmail(email);
        if(userList.size() == 0){
            throw new UsernameNotFoundException("user not found");
        }
        return userList.get(0).getId();
    };

    public void deleteUser(Integer userId){
        userRepository.deleteById(userId);
    }

    public List<User> findUserByUserId(Integer id){
        return userRepository.findAllById(Collections.singleton(id));
    }

    public List<User> findUserByEmail(String email) {return userRepository.findAllByEmail(email);}

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public String getHashedPassword(String string) {return encodePassword.passwordEncoder().encode(string);}
}

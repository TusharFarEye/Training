package com.fareye.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {
    @Autowired
    private UserDetailsService userDetailsService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(){
        return "hello welcome to spring";
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currUser(Authentication auth){
        return "hello welcome to spring"+auth.getName();
    }


    @RequestMapping(value = "/admin/user/{username}", method = RequestMethod.GET)
    public UserDetails getListOfUser(@PathVariable String username){
        return userDetailsService.loadUserByUsername(username);
    }



}

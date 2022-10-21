package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    void createUser() {
        RestTemplate restTemplate = new RestTemplate();
        User user = new User();
        user.setFirstName("tushar");
        user.setEmail("tushar01shandilya@gmail.com");
        User response= restTemplate.postForObject("http://localhost:8080/post-user", user, User.class);

        assertEquals(response.getFirstName(), user.getFirstName());
    }

    @Test
    void getUser(){
        String url = "http://localhost:8080/get-user";
        String expectedStatus = "200 OK";
        RestTemplate restTemplate = new RestTemplate();

        //and do I need this JSON media type for my use case?
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //set my entity
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response.getBody());
        assertEquals(response.getStatusCode().toString(), expectedStatus);
    }

    @Test
    void deleteUser(){
        String url = "http://localhost:8080/delete-user";
        String expectedStatus = "200 OK";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //set my entity
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);

        String email =  "tushar01shandilya@gmail.com";

        ResponseEntity<String> response = restTemplate.exchange(url+"?email="+ email, HttpMethod.DELETE, entity, String.class);

        System.out.println(response.getBody());
        assertEquals(response.getStatusCode().toString(), expectedStatus);
    }

    @Test
    void putUser(){
        String url = "http://localhost:8080/put-user";
        String expectedStatus = "200 OK";
        RestTemplate restTemplate = new RestTemplate();

        User user = new User();
        user.setFirstName("tushar");
        user.setEmail("tushar01shandilya@gmail.com");

        //set my entity
        HttpEntity<User> entity = new HttpEntity<User>(user);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);

        System.out.println(response.getBody());

        assertNotNull(response);
        assertEquals(response.getStatusCode().toString(), expectedStatus);
    }

}
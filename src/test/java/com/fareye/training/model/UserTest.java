package com.fareye.training.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void add() {
        User user  = new User();
        assertEquals(4, user.add(2,2));
    }
}
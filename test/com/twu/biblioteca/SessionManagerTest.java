package com.twu.biblioteca;

import com.twu.biblioteca.dto.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class SessionManagerTest {
    User user = new User("123-456", "password", "User 1", "Surname 1", "123-456@biblioteca.com", 123456789);
    User nonExistingUser = new User("999-999", "password", "User 9", "Surname 9", "999-999@biblioteca.com", 999999999);

    SessionManager sessionManager = new SessionManager();

    @Test
    public void unsuccessfulLogInTest(){
        assertFalse(sessionManager.nonExistingUser(user.getId(), user.getPassword()));
    }
}
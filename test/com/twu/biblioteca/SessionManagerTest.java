package com.twu.biblioteca;

import com.twu.biblioteca.dto.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class SessionManagerTest {
    User user = new User("123-456", "password", "User 1", "Surname 1", "123-456@biblioteca.com", 123456789);
    User nonExistingUser = new User("999-999", "password", "User 9", "Surname 9", "999-999@biblioteca.com", 999999999);

    SessionManager sessionManager = new SessionManager();


    @Test
    public void unsuccessfulLoginTest(){
        assertFalse(sessionManager.login(nonExistingUser.getId(), nonExistingUser.getPassword()));
    }

    @Test
    public void loginTest(){
        assertTrue(sessionManager.login(user.getId(), user.getPassword()));
    }

    @Test
    public void unsuccessfulLoginTest_wrongPasswd(){
        assertFalse(sessionManager.login(nonExistingUser.getId(), nonExistingUser.getPassword() + "pass"));
    }

    @Test
    public void loginTest_recoverUser(){
        sessionManager.login(user.getId(), user.getPassword());
        assertEquals(sessionManager.getUserLoged(), user);
    }

    @Test
    public void unsuccessfulLoginTest_recoverUser(){
        sessionManager.login(nonExistingUser.getId(), "wrongPASS");
        assertEquals(sessionManager.getUserLoged().getId(), null);
    }

}
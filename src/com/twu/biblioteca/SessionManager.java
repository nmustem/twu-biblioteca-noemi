package com.twu.biblioteca;

import com.twu.biblioteca.dto.User;
import com.twu.biblioteca.utils.BiblotecaConstants;

public class SessionManager {
    private User userLoged = new User();

    public SessionManager() {
    }

    public Boolean login(String id, String password) {
        for(User user : BiblotecaConstants.BIBLOTECA_USERS){
            if(user.getId().equals(id) && user.getPassword().equals(password)){
                userLoged = user;
                return true;
            }
        }
        userLoged = new User();
        return false;
    }

    public User getUserLoged() {
        return userLoged;
    }

    public void setUserLoged(User userLoged) {
        this.userLoged = userLoged;
    }
}

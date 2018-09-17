package com.twu.biblioteca;

import com.twu.biblioteca.dto.User;
import com.twu.biblioteca.utils.BiblotecaConstants;

public class SessionManager {

    public SessionManager() {
    }

    public Boolean login(String id, String password) {
        for(User user : BiblotecaConstants.BIBLOTECA_USERS){
            if(user.getId().equals(id) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}

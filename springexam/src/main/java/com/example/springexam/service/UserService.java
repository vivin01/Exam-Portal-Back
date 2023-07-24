package com.example.springexam.service;

import com.example.springexam.model.User;
import com.example.springexam.model.UserRole;

import java.util.Set;

public interface UserService {

    // Creating User
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    // We create a method name createUser() which return the User type data
    // in this we pass two parameter first is user and second is the roles of user(roles can be multiple so we take roles in Set form)
    public User getUser(String username);

    public void deleteUser(long userId);

}

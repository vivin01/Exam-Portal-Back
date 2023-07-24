package com.example.springexam.controller;

import com.example.springexam.model.Role;
import com.example.springexam.model.User;
import com.example.springexam.model.UserRole;
import com.example.springexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController // this is use for to control links in webpage
@RequestMapping("/user") // this is used to give a address link in webpage
@CrossOrigin("*") // this is use for to allow all domains of our angular,
// in simple words we run this spring app in port 8080 and angular in 4200, so to accept req from different port of angular we use this
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/") // this means that we give one more "/", then this method will execute
    public User createUser(@RequestBody User user) throws Exception {

        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(2L);
        role.setRoleName("USER");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return userService.createUser(user, roles);
    }

    @GetMapping("/{username}")// this is used to get the data from the database of the entered username
    public User getUser( @PathVariable("username") String username) {
        return userService. getUser(username);
    }

    @DeleteMapping("/{userId}") // this is used to delete a data of user using  userId
    public void deleteUser(@PathVariable("userId") long userId){
        userService.deleteUser(userId);
    }

}


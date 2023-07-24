package com.example.springexam.service.impl;

import com.example.springexam.model.User;
import com.example.springexam.model.UserRole;
import com.example.springexam.repo.RoleRepository;
import com.example.springexam.repo.UserRepository;
import com.example.springexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //CREATING USER
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if (local !=null){// if user already exists
            System.out.println("User already exists");
            throw new Exception("User already exists");
        }
        else {
            // creating user
            for (UserRole ur: userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRole().addAll(userRoles);
            local = this.userRepository.save(user);
        }

        return local;
    }

    // GETTING USER BY USING USERNAME
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    //DELETING USER USING USERID
    @Override
    public void deleteUser(long userId) {
        this.userRepository.deleteById(userId);
    }

}

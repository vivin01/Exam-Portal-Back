package com.example.springexam.repo;

import com.example.springexam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // in this jpa we have to give the input Entity and its accepting data type(datatype of Id) to its generics

    public User findByUsername(String username);

    void deleteByUsername(String username);
}

package com.example.springexam.repo;

import com.example.springexam.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // in this jpa we have to give the input Entity and its accepting data type(datatype of Id) to its generics

}

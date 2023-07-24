package com.example.springexam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

// this class or Entity is used to define the table which store the combine details that which use get which role
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // this is used when we want to auto generate the data using the different tables,
    // means we add data in users table then it will update that data in all connected tables
    private long userRoleId;

    @JsonIgnore// we need to ignore the JSON, because it cannot handle the JSON, when it get data in JSON format
    @ManyToOne(fetch = FetchType.EAGER) // here we give reverse of one to many because we have the many roles for one user
    private User user; // we give mapping in User class for this variable

    @JsonIgnore// we need to ignore the JSON, because it cannot handle the JSON, when it get data in JSON format
    @ManyToOne
    private Role role;

    public UserRole() {
    }

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

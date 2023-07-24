package com.example.springexam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    private String roleName;
    private Long roleId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")// here we give One to many because we have the one user with many roles
    // cascade is used to delete the data when we delete the user
    // fetch is used to fetch the data, when we fetch user then it will only return the required data
    // mappedBy is used to map the data using the variable name "role" which is in the class UserRole
    @JsonIgnore // this is used to ignore the JSON for this
    private Set<UserRole> userRoles = new HashSet<>();

    public Role() {
    }

    public Role(String roleName, Long roleId) {
        this.roleName = roleName;
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}

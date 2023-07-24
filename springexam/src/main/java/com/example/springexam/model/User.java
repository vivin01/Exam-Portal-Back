package com.example.springexam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users") // here table name is set as users
public class User implements UserDetails
// here we override the methods of user details which is used in spring security
{

    @Id // this is for primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //@Column(name = "password", nullable = false) this is used to give a columns
    private String password;
    private String username;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private boolean enabled = true;
    private String profile;
    public User() {

    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")// here we give One to many because we have the one user with many roles
    // cascade is used to delete the data when we delete the user
    // fetch is used to fetch the data, when we fetch user then it will automatically fetch the role ot that user
    // mappedBy is used to map the data using the variable name "user" which is in the class UserRole
    @JsonIgnore // this is used to ignore the JSON for this
    private Set<UserRole> userRoles = new HashSet<>(); // in this sometimes the single user has multiple roles, so we pass that roles in list form

    public User(long id, String password, String name, String email, String phone, String firstName, String lastName, boolean enabled, String profile) {
        this.id = id;
        this.password = password;
        this.username = name;
        this.email = email;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.profile = profile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Set<UserRole> getUserRole() {
        return userRoles;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRoles = userRole;
    }

    // from here we are using the overRidden methods

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // here we return the roles of the user, that what role does user had

        Set<Authority> set = new HashSet<>();

        this.userRoles.forEach(userRole -> {
            set.add(new Authority(userRole.getRole().getRoleName()));
        });

        return null;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}

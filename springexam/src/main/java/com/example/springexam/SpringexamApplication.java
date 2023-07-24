// vivin mevada

package com.example.springexam;

import com.example.springexam.model.Role;
import com.example.springexam.model.User;
import com.example.springexam.model.UserRole;
import com.example.springexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringexamApplication implements CommandLineRunner {// this commandLineRunner is used to run the project in specific area

	@Autowired
	private UserService UserService; // we need to create this, because this is an interface

	public static void main(String[] args) {
		SpringApplication.run(SpringexamApplication.class, args);
		// this is nothing just comment for GitHub
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting Application...");

		// we comment this portion because we don't need to create same user every time, and we get an exception

//		User user = new User();
//
//		user.setFirstName("Vivin");
//		user.setLastName("Mevada");
//		user.setUsername("vivinmevada");
//		user.setPassword("123456789");
//		user.setEmail("vivinmevada01@gmail");
//		user.setPhone("9327787493");
//		user.setProfile("vivin.png");
//
//		Role role = new Role();
//		role.setRoleName("ADMIN");
//		role.setRoleId(1L);
//
//		Set<UserRole> userRolesSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//
//		userRole.setRole(role);
//		userRole.setUser(user);
//
//		userRolesSet.add(userRole);
//
//		User user1 = this.UserService.createUser(user, userRolesSet);
//		System.out.println(user1.getUsername());
	}
}

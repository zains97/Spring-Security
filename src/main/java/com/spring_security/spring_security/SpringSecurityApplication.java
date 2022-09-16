package com.spring_security.spring_security;

import com.spring_security.spring_security.Role.Role;
import com.spring_security.spring_security.User.AppUser;
import com.spring_security.spring_security.User.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @GetMapping
    String hello() {
        return "Hello from spring security app.";
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return (args) -> {
            userService.saveUser(new AppUser(null, "Zain Saleem", "zains97", "xsxax", new ArrayList<Role>()));
            userService.saveUser(new AppUser(null, "Ahmed Saleem", "ahmed04", "xsxax", new ArrayList<Role>()));
            userService.saveUser(new AppUser(null, "Aisha Ali", "aisha01", "xsxax", new ArrayList<Role>()));

            userService.saveRole((new Role(null, "ROLE_ADMIN")));
            userService.saveRole((new Role(null, "ROLE_MANAGER")));
            userService.saveRole((new Role(null, "ROLE_USER")));

            userService.addRoleToUser("zains97", "ROLE_ADMIN");
            userService.addRoleToUser("zains97", "ROLE_MANAGER");
            userService.addRoleToUser("ahmed04", "ROLE_MANAGER");
            userService.addRoleToUser("aisha01", "ROLE_USER");
        };
    }
}

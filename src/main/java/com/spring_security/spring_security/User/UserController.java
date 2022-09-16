package com.spring_security.spring_security.User;

import com.spring_security.spring_security.Role.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping
    ResponseEntity<List<AppUser>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping
    ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping(path = "/role")
    ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping(path = "/addtouser")
    ResponseEntity<?> addRoleToUser(@RequestBody AddRoleToUserReqBody body) {
        userService.addRoleToUser(body.userName, body.roleName);
        return ResponseEntity.ok().build();
    }

    @Data
    class AddRoleToUserReqBody {
        private String userName;
        private String roleName;
    }
}

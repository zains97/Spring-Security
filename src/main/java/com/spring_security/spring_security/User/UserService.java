package com.spring_security.spring_security.User;

import com.spring_security.spring_security.Role.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    AppUser getUser(String usename);
    List<AppUser> getUsers();
}

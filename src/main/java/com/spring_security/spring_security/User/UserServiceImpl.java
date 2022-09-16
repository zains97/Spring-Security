package com.spring_security.spring_security.User;

import com.spring_security.spring_security.Role.Role;
import com.spring_security.spring_security.Role.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Creating new user");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Creating new role");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role to user");
        AppUser user = userRepo.findByUserName(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("getting user");
        return userRepo.findByUserName(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("getting all users");
        return userRepo.findAll();
    }
}

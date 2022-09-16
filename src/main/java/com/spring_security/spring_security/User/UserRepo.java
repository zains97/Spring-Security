package com.spring_security.spring_security.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser,Integer> {
    AppUser findByUserName(String userName);
}

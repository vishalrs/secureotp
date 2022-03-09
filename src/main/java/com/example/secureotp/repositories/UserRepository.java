package com.example.secureotp.repositories;

import com.example.secureotp.common.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

}

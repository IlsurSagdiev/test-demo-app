package com.example.test.repository;

import com.example.test.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String username);

    Optional<User> findByEmail(String identifier);

    Optional<User> findByPhone(String identifier);
}
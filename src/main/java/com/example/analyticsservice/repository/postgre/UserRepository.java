package com.example.analyticsservice.repository.postgre;

import com.example.analyticsservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Boolean existsUserByUsername(String username);
    Boolean existsByEmail(String email);
    //User findByEmail(String email);
    Optional<User> findByEmail(String email);
}

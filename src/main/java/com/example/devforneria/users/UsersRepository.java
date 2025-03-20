package com.example.devforneria.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository  extends JpaRepository<Users, Long> {
    //find a user by their email
    Optional<Users> findByEmail(String email);
}

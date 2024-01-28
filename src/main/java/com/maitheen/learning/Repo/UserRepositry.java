package com.maitheen.learning.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maitheen.learning.Entity.User;

@Repository
public interface UserRepositry extends JpaRepository<User, Long> {
   User findByEmail(String email);
   User findByEmailAndPassword(String email,String password);
   // User findByEmailAndPasswordAndUpdate(User user);
   Optional<User> findById(Long id);
    void deleteById(Long id);
}

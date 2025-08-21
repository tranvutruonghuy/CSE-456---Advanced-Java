package com.example.FinalMockTest.repository;

import com.example.FinalMockTest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User searchUserByUsernameIgnoreCase(String username);
}

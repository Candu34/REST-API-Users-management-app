package com.example.restapiusersmanagementapp.repository;

import com.example.restapiusersmanagementapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

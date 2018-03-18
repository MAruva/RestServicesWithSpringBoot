package com.mallikaaruva.springbootusers.repository;

import com.mallikaaruva.springbootusers.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByName(String name);
    Users findById(long id);
    List<Users> findAll();
}
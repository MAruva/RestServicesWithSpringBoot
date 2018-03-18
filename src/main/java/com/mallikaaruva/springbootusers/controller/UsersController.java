package com.mallikaaruva.springbootusers.controller;

import com.mallikaaruva.springbootusers.model.Users;
import com.mallikaaruva.springbootusers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/all")
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{name}")
    public Users findByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }

    @PostMapping(value = "/load")
    public Users loadUsers(@ModelAttribute final Users users) {
        userRepository.save(users);
        return userRepository.findByName(users.getName());

    }

    @DeleteMapping(value = "/{name}")
    public List<Users> deleteUser(@PathVariable String name) {
        Users user = userRepository.findByName(name);
        userRepository.deleteById(user.getId());
        return userRepository.findAll();
    }

    @PutMapping(value = "/{id}/{name}")
    public List<Users> updateUse(@PathVariable long id, @PathVariable String name) {
        Users user = userRepository.findById(id);
        boolean value = userRepository.existsById(user.getId());
        if (value) {
            user.setName(name);
            user.setId(id);
            userRepository.save(user);
            return userRepository.findAll();
        }
        return null;
    }
}


package com.example.reactivedemo.controller;

import com.example.reactivedemo.entity.User;
import com.example.reactivedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by jack on 2018/4/14 0014.
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/save")
    public Boolean save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }

    @GetMapping("/findAll")
    public Collection<User> findAll(){
        return userRepository.userConcurrentMap.values();
    }
}

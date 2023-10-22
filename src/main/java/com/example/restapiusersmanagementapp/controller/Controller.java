package com.example.restapiusersmanagementapp.controller;


import com.example.restapiusersmanagementapp.model.User;
import com.example.restapiusersmanagementapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class Controller {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        return userService.findById(id);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public long saveUser(@RequestBody User user){
       return userService.save(user);
    }

    @PutMapping("/{id}")
    public Map<String, String> updateUserStatus(@PathVariable String id){
       return userService.updateUserStatus(Long.parseLong(id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){

    }


}

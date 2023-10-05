package com.example.restapiusersmanagementapp.controller;


import com.example.restapiusersmanagementapp.model.User;
import com.example.restapiusersmanagementapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        return userService.findById(id);
    }

    @PostMapping
    public long saveUser(@RequestBody User user){
       return userService.save(user);
    }

    @PutMapping()
    public void updateUserStatus(){

    }



}

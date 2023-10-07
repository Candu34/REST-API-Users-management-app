package com.example.restapiusersmanagementapp.controller;


import com.example.restapiusersmanagementapp.model.User;
import com.example.restapiusersmanagementapp.service.UserService;
import com.example.restapiusersmanagementapp.util.UserErrorResponse;
import com.example.restapiusersmanagementapp.util.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public long saveUser(@RequestBody User user){
       return userService.save(user);
    }

    @PutMapping("/{id}")
    public Map<String, String> updateUserStatus(@PathVariable String id){
       return userService.updateUserStatus(Long.parseLong(id));
    }

//    @ExceptionHandler
//    private ResponseEntity<UserErrorResponse> exceptionHandler(UserNotFoundException e){
//        UserErrorResponse response = new UserErrorResponse("Person with this id wasn't found",
//                System.currentTimeMillis());
//        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//    }



}

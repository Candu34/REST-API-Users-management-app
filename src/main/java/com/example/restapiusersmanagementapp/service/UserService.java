package com.example.restapiusersmanagementapp.service;

import com.example.restapiusersmanagementapp.model.User;
import com.example.restapiusersmanagementapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserService{

@Autowired
private final UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User findById(long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);

    }

    @Transactional(readOnly = false)
    public long save(User user){
       long id = userRepository.save(user).getId();
       return id;
    }

    public void updateUserStatus(long id, String status){
       User userToUpdate = userRepository.findById(id).get();

       userToUpdate.setStatus(status);
    }








}

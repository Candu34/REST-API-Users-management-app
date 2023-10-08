package com.example.restapiusersmanagementapp.service;

import com.example.restapiusersmanagementapp.model.User;
import com.example.restapiusersmanagementapp.repository.UserRepository;
import com.example.restapiusersmanagementapp.util.exceptions.UserExistingEmailException;
import com.example.restapiusersmanagementapp.util.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        return user.orElseThrow(UserNotFoundException::new);
    }

    @Transactional(readOnly = false)
    public long save(User user){
        if(userRepository.findByEmail(user.getEmail()) != null)
            throw new UserExistingEmailException();
        else {
            long id = userRepository.save(user).getId();
            return id;
        }
    }

    @Transactional(readOnly = false)
    public Map<String, String> updateUserStatus(long id){
        Map<String, String> updateResponse= new HashMap<>();

         User userToUpdate = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

         updateResponse.put("id", Long.toString(id));
         updateResponse.put("previos status", userToUpdate.getStatus());
         updateResponse.put("current status", userToUpdate.changeStatus());

        return updateResponse;
    }








}

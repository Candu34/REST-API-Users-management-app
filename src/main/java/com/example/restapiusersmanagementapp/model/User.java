package com.example.restapiusersmanagementapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surName")
    private String surName;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;

    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    @Column(name = "status", nullable = false)
    private String status;

    public String changeStatus(){
        String currentStatus = getStatus().equals("online") ? "offline" : "online";
        setStatus(currentStatus);

        return currentStatus;
    }

}

package com.example.restapiusersmanagementapp.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class UserErrorResponse {

    private final String message;
    private final long timestamp;

}

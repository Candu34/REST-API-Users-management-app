package com.example.restapiusersmanagementapp.util.exceptions;


import com.example.restapiusersmanagementapp.util.exceptions.UserErrorResponse;
import com.example.restapiusersmanagementapp.util.exceptions.UserExistingEmailException;
import com.example.restapiusersmanagementapp.util.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionsHandler {
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<UserErrorResponse> handleUserNotFoundException(){
        UserErrorResponse userErrorResponse = new UserErrorResponse("User with this id wasn't found!",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(userErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserExistingEmailException.class)
    public ResponseEntity<UserErrorResponse> handleUserExistingEmailException(){
        UserErrorResponse userErrorResponse = new UserErrorResponse("User with this email already exists",
                System.currentTimeMillis());


        return new ResponseEntity<>(userErrorResponse,HttpStatus.CONFLICT);
    }

}

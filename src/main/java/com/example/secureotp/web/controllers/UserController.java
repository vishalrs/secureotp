package com.example.secureotp.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/info")
    public ResponseEntity<String> getUserInfo(){
        return new ResponseEntity<String>("Hello", HttpStatus.OK);
    }

}

package com.example.secureotp.web.controllers;

import com.example.secureotp.common.model.User;
import com.example.secureotp.services.UserPrincipalDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

    UserPrincipalDetailsService userDetailsService;

    public UserController(UserPrincipalDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/info")
    public ResponseEntity<User> getUserInfo(Principal principal){
        System.out.printf(principal.getName());
        return new ResponseEntity<>(userDetailsService.getUser(principal.getName()), HttpStatus.OK);
    }


    @GetMapping("/otp")
    public ResponseEntity<String> gteOtp(@RequestParam("username") String username){
        return new ResponseEntity<>(userDetailsService.generateOtp(username), HttpStatus.OK);
    }
}

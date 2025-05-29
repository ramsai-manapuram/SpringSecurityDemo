package com.flipkart.flipkart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.flipkart.entity.UserAuthEntity;
import com.flipkart.flipkart.services.UserAuthEntityService;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private UserAuthEntityService userAuthEntityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserAuthEntity userAuthDetails) {
        // Hash the password before saving
        System.out.println("Before encoding: " + userAuthDetails.getPassword());
        userAuthDetails.setPassword(passwordEncoder.encode(userAuthDetails.getPassword()));
        System.out.println("Username: " + userAuthDetails.getUsername() + " Password: " + userAuthDetails.getPassword());

        // Save user
        userAuthEntityService.save(userAuthDetails);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/")
    public ResponseEntity<String> printHello() {
        return ResponseEntity.ok("Helloo");
    }
}

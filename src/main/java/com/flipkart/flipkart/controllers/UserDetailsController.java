package com.flipkart.flipkart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsController {

    @GetMapping("/")
    public String defaultHomePageMethod() {
        return "Hello, you are logged in";
    }

    @GetMapping("/users")
    public String getUsersDetails() {
        return "Fetched the details of user successfully";
    }
}

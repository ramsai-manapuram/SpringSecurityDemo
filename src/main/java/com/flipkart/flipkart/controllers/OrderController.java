package com.flipkart.flipkart.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/place")
    public ResponseEntity<String> placeOrder() {
        System.out.println("Hitting the /placeOrder end point");
        String result = "Order Placed, Thank you for shopping with us!!!";
        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        System.out.println("Hitting the /health-check end point");
        String result = "Flipkart service is up";
        return ResponseEntity.status(200).body(result);
    }

}

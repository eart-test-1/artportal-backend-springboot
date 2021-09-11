package com.ecommerce.artportal.artshop.controller;

import com.ecommerce.artportal.artshop.model.RegisterRequest;
import com.ecommerce.artportal.artshop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest user) {
        String message = userInfoService.registerUser(user);
        System.out.println(message);
        return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
    }
}

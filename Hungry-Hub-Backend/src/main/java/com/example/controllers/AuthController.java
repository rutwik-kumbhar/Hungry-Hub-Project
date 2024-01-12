package com.example.controllers;


import com.example.entities.User;
import com.example.paylode.AuthResponse;
import com.example.paylode.Login;
import com.example.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/user/sign/up")
    public ResponseEntity<User> addUser(@RequestBody User user){
        user.setRole("ROLE_USER");
        return new ResponseEntity<>(userServices.creareUser(user), HttpStatus.CREATED);
    }
    @PostMapping("/admin/sign/up")
    public ResponseEntity<User> addAdmin(@RequestBody User user){
        user.setRole("ROLE_ADMIN");
        return new ResponseEntity<>(userServices.creareUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/user/sign/in")
    public ResponseEntity<AuthResponse> userLogin(@RequestBody Login login){
        return  new ResponseEntity<>(userServices.loginUser(login),HttpStatus.OK);
    }



}

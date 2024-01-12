package com.example.controllers;


import com.example.entities.User;
import com.example.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserServices userServices;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){
//        System.out.println(id);
        return  new ResponseEntity<>(userServices.findUserById(id), HttpStatus.OK);
    }


    @GetMapping("/jwt")
    public ResponseEntity<User> getUserByJwt(@RequestHeader("Authorization") String authorizationHeader){
        String jwtToken = authorizationHeader.substring(7);
        return  new ResponseEntity<>(userServices.findUserByJwt(jwtToken), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(){
        return null;
    }


}

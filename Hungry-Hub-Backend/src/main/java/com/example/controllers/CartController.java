package com.example.controllers;


import com.example.entities.Food;
import com.example.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/cart")
public class CartController {


    @Autowired
    private CartService cartService;

    @PostMapping("/food/{foodId}")
    public ResponseEntity<Food> addFoodIntoCart(@RequestHeader("Authorization") String authorizationHeader, @PathVariable Integer foodId){
        String token = authorizationHeader.substring(7);
        return  new ResponseEntity<Food>(cartService.addFoodIntoCart(token ,foodId), HttpStatus.OK);
    }


    @GetMapping("/food")
    public ResponseEntity<List<Food>> getAllCartItem(@RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.substring(7);
        return  new ResponseEntity<List<Food>>(cartService.getAllFoodFromCart(token),HttpStatus.OK);
    }

}

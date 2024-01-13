package com.example.services;

import com.example.entities.Food;

import java.util.List;


public interface CartService {

    /**
     * This methode for add food into cart;
     * @param token
     * @param foodId
     * @return Food
     */
    Food addFoodIntoCart(String token , Integer foodId);


    /**
     * This method get all food from cart
     * @param token
     * @return set of foods
     */
    List<Food> getAllFoodFromCart(String token);
}

package com.example.services;

import com.example.entities.Food;
import com.example.paylode.DeleteResponse;

import java.util.List;

public interface FoodService {


    /**
     * This method add new food
     * @param food
     * @return newly added food
     */
    Food createFood(Food food);

    /**
     * This method get all foods
     * @return list of foods
     */
    List<Food> getAllFoods();

    /**
     * This method get food by id
     * @param id
     * @return food
     */
    Food getFoodById(Integer id);

    /**
     * This method get food by category name
     * @param categoryName
     * @return list of food
     */
    List<Food> getFoodByCategoryName(String categoryName);

    /**
     * This method update existing food
     * @param id
     * @param food
     * @return updated food
     */
    Food updateFood(Integer id ,Food food);


    /**
     * This method delete food
     * @param id
     * @return delete response
     */
    DeleteResponse deleteFood(Integer id);




}

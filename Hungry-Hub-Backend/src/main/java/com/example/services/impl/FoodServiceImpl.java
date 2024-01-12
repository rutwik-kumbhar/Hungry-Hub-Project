package com.example.services.impl;

import com.example.Repositories.FoodCategoryRepository;
import com.example.Repositories.FoodRepository;
import com.example.entities.Food;
import com.example.entities.FoodCategory;
import com.example.exceptions.ResourcesNotFoundException;
import com.example.paylode.DeleteResponse;
import com.example.services.FoodCategoryService;
import com.example.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {


    private final FoodRepository foodRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final FoodCategoryService foodCategoryService;


    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository, FoodCategoryRepository foodCategoryRepository, FoodCategoryService foodCategoryService) {
        this.foodRepository = foodRepository;
        this.foodCategoryRepository = foodCategoryRepository;
        this.foodCategoryService = foodCategoryService;
    }

    /**
     * This method add new food
     * @param food
     * @return newly added food
     */
    @Override
    public Food createFood(Food food) {
        FoodCategory foodCategory =  foodCategoryService.getCategoryByName(food.getCategory());
        food.setFoodCategory(foodCategory);
        foodCategory.setFoods(List.of(food));
        return foodRepository.save(food);
    }

    /**
     * This method get all foods
     * @return list of foods
     */
    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    /**
     * This method get food by id
     * @param id
     * @return food
     */
    @Override
    public Food getFoodById(Integer id) {
        Optional<Food> opt =  foodRepository.findById(id);
        return opt.orElseThrow(()-> new ResourcesNotFoundException("Food not found by give id " + id));
    }

    /**
     * This method get food by category name
     * @param categoryName
     * @return list of food
     */
    @Override
    public List<Food> getFoodByCategoryName(String categoryName) {
       FoodCategory foodCategory =  foodCategoryService.getCategoryByName(categoryName);
        return foodCategory.getFoods();
    }

    /**
     * This method update existing food
     * @param id
     * @param food
     * @return updated food
     */
    @Override
    public Food updateFood(Integer id, Food food) {
        return null;
    }

    /**
     * This method delete food
     * @param id
     * @return delete response
     */
    @Override
    public DeleteResponse deleteFood(Integer id) {
       Food food =   this.getFoodById(id);
        foodRepository.delete(food);
        return DeleteResponse.builder().message("Food deleted successfully..!").status(true).build();
    }
}

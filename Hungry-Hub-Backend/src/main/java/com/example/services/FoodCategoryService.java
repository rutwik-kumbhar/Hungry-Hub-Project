package com.example.services;

import com.example.Repositories.FoodCategoryRepository;
import com.example.entities.FoodCategory;
import com.example.paylode.DeleteResponse;

import java.util.List;

public interface FoodCategoryService {

    /**
     * This method add new food category
     * @param foodCategory
     * @return new added food category
     */
    FoodCategory createCatogory(FoodCategory foodCategory);

    /**
     * This method get food category by id
     * @param id
     * @return Food Category
     */
    FoodCategory getCategory(Integer id);

    /**
     * This method get category by name
     * @param categoryName
     * @return Food Category
     */
    FoodCategory getCategoryByName(String categoryName);

    /**
     * This method for get all food categories
     * @return  List of food categories
     */
    List<FoodCategory> getAllCategory();

    /**
     * This method update food category
     * @param id
     * @param foodCategory
     * @return updated food category
     */
    FoodCategory updateCategory(Integer id , FoodCategory foodCategory);


    /**
     * This method for delete food category
     * @param id
     * @return DeleteResponse
     */
    DeleteResponse deleteCategory(Integer id);

}

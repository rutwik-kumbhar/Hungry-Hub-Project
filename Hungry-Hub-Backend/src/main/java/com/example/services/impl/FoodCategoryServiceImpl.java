package com.example.services.impl;

import com.example.Repositories.FoodCategoryRepository;
import com.example.entities.FoodCategory;
import com.example.exceptions.AlreadyExistException;
import com.example.exceptions.ResourcesNotFoundException;
import com.example.paylode.DeleteResponse;
import com.example.services.FoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {


    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    /**
     * This method add new food category
     * @param foodCategory
     * @return new added food category
     */
    @Override
    public FoodCategory createCatogory(FoodCategory foodCategory) {
        Optional<FoodCategory> opt = foodCategoryRepository.findByCategory(foodCategory.getCategory());
        if(opt.isPresent()) throw  new AlreadyExistException("Food category already exist by given category name " + foodCategory.getCategory());
        return foodCategoryRepository.save(foodCategory);
    }

    /**
     * This method get food category by id
     * @param id
     * @return Food Category
     */
    @Override
    public FoodCategory getCategory(Integer id) {
        Optional<FoodCategory>  opt = foodCategoryRepository.findById(id);
        return opt.orElseThrow(()-> new ResourcesNotFoundException("Food category not found by give id " + id));
    }

    @Override
    public FoodCategory getCategoryByName(String categoryName) {
        Optional<FoodCategory> opt =  foodCategoryRepository.findByCategory(categoryName);
        return opt.orElseThrow(()-> new ResourcesNotFoundException("Category not found by give name " + categoryName));
    }

    /**
     * This method for get all food categories
     * @return List of food categories
     */
    @Override
    public List<FoodCategory> getAllCategory() {
        return foodCategoryRepository.findAll();
    }

    /**
     * This method update food category
     * @param id
     * @param foodCategory
     * @return updated food category
     */
    @Override
    public FoodCategory updateCategory(Integer id ,FoodCategory foodCategory) {
        FoodCategory existFoodCategory = this.getCategory(id);
        existFoodCategory.setCategory(foodCategory.getCategory());
        return  foodCategoryRepository.save(existFoodCategory);
    }

    /**
     * This method for delete food category
     * @param id
     * @return DeleteResponse
     */
    @Override
    public DeleteResponse deleteCategory(Integer id) {
        FoodCategory foodCategory = this.getCategory(id);
        foodCategoryRepository.delete(foodCategory);
        return DeleteResponse.builder().message("Food category deleted successfully..!").status(true).build();
    }
}

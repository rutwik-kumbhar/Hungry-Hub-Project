package com.example.controllers;


import com.example.entities.FoodCategory;
import com.example.paylode.DeleteResponse;
import com.example.services.FoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food/category")
public class FoodCategoryController {

    @Autowired
    private FoodCategoryService foodCategoryService;

    @PostMapping("/add")
    public ResponseEntity<FoodCategory> addCategory(@RequestBody FoodCategory foodCategory){
        return  new ResponseEntity<>(foodCategoryService.createCatogory(foodCategory), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<FoodCategory> getCategory(@PathVariable Integer id){
        return  new ResponseEntity<>(foodCategoryService.getCategory(id),HttpStatus.OK);
    }
    @GetMapping()
    public  ResponseEntity<FoodCategory> getCategoryByName(@RequestParam String category){
        return  new ResponseEntity<>(foodCategoryService.getCategoryByName(category),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FoodCategory>> getAllCategory(){
        return new ResponseEntity<>(foodCategoryService.getAllCategory(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FoodCategory> updateCategory(@PathVariable Integer id , @RequestBody FoodCategory foodCategory){
        return  new ResponseEntity<>(foodCategoryService.updateCategory(id, foodCategory),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponse> deleteCategory(@PathVariable Integer id){
        return  new ResponseEntity<>(foodCategoryService.deleteCategory(id),HttpStatus.OK);
    }





}

package com.example.controllers;


import com.example.entities.Food;
import com.example.paylode.DeleteResponse;
import com.example.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {


    @Autowired
    private FoodService foodService;


    @PostMapping("/add")
    public ResponseEntity<Food> addFood(@RequestBody Food food){
        return new ResponseEntity<Food>(foodService.createFood(food), HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Food>> getAllFoods(){
         return  new ResponseEntity<>(foodService.getAllFoods(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFood(@PathVariable Integer id){
        return  new ResponseEntity<Food>(foodService.getFoodById(id),HttpStatus.OK);
    }


    @GetMapping("/category/name/{name}")
    public ResponseEntity<List<Food>> getFoodByCategoryName(@PathVariable(name = "name") String categoryName){
        System.out.println(categoryName);
        return  new ResponseEntity<>(foodService.getFoodByCategoryName(categoryName),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponse> deleteFood(@PathVariable  Integer id){
        return  new ResponseEntity<DeleteResponse>(foodService.deleteFood(id),HttpStatus.OK);
    }





}

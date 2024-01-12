package com.example.Repositories;

import com.example.entities.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Integer> {
    public Optional<FoodCategory> findByCategory(String category);
}

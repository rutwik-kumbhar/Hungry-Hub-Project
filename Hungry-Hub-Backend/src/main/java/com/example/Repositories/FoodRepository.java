package com.example.Repositories;

import com.example.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodRepository  extends JpaRepository<Food,Integer> {
}

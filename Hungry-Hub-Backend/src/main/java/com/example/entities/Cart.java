package com.example.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  Integer quantity;

    private  double totalPrice;

    private Set<Integer> foodListId = new HashSet<>();

    @ManyToOne()
    @JoinColumn(name =  "user_id")
    private User user;




}

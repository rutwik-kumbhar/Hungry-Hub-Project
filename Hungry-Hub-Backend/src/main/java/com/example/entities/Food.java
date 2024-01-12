package com.example.entities;


import jakarta.persistence.*;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String title;

    private String description;
    private Double price;
    private String imageUrl;
    private Integer deliverTime;

    @Transient
    private String category;


    @ManyToOne
    @JoinColumn(name =  "foodcategory_id")
    private  FoodCategory foodCategory;
}

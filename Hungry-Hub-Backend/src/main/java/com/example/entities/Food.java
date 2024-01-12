package com.example.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String category;


    @ManyToOne()
    @JoinColumn(name =  "foodcategory_id" )
    @JsonIgnore
    private  FoodCategory foodCategory;
}

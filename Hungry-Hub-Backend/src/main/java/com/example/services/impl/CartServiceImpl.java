package com.example.services.impl;

import com.example.Repositories.CartRepository;
import com.example.Repositories.FoodRepository;
import com.example.Repositories.UserRepository;
import com.example.config.JwtTokenProvider;
import com.example.entities.Cart;
import com.example.entities.Food;
import com.example.entities.User;
import com.example.exceptions.AlreadyExistException;
import com.example.exceptions.ResourcesNotFoundException;
import com.example.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class CartServiceImpl implements CartService {



    private final UserRepository userRepository;
    private final FoodRepository foodRepository;
    private  final JwtTokenProvider jwtTokenProvider;
    private final  CartRepository cartRepository;


    @Autowired
    public CartServiceImpl(UserRepository userRepository, FoodRepository foodRepository, JwtTokenProvider jwtTokenProvider, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.cartRepository = cartRepository;

    }

    /**
     * This methode for add food into cart;
     * @param token
     * @param foodId
     * @return Food
     */
    @Override
    public Food addFoodIntoCart(String token, Integer foodId) {
        User user = this.getUserFromToken(token);

        Optional<Food> optionalFood =  foodRepository.findById(foodId);

        Food food =  optionalFood.orElseThrow(()-> new ResourcesNotFoundException("Food not found given id"+ foodId));

        Cart cart =  user.getCart();

        if (cart == null){
            cart = new Cart();
            user.setCart(cart);
            cart.setUser(user);

            cart.setQuantity(1);
            cart.setTotalPrice(food.getPrice());
            cart.getFoodListId().add(foodId);
        }else{
            if(cart.getFoodListId().add(foodId)){
                cart.setQuantity(cart.getQuantity()+1);
                cart.setTotalPrice(cart.getTotalPrice()+food.getPrice());
                cart.getFoodListId().add(foodId);

            }else{
                throw  new AlreadyExistException("Product Already In Cart ");
            }
        }

        userRepository.save(user);
        return food;
    }

    /**
     * This method get all food from cart
     * @param token
     * @return list of foods
     */
    @Override
    public List<Food> getAllFoodFromCart(String token) {
        User user = this.getUserFromToken(token);
        List<Food> foods = new ArrayList<>();

        Cart cart =  user.getCart();
        if(cart == null){
            return  foods;
        }
        Set<Integer> foodIds =  cart.getFoodListId();

        foodIds.forEach((id)-> {
            foods.add( foodRepository.findById(id).get());
        });

        return foods;
    }


    private User getUserFromToken(String token){
        String username =  jwtTokenProvider.getUsernameFromToakn(token);
        Optional<User> userOptional = userRepository.findByEmail(username);
        return userOptional.orElseThrow(()-> new ResourcesNotFoundException("User Not Login...! Please Login First" ));
    }


}
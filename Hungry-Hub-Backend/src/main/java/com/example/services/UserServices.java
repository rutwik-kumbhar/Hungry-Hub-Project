package com.example.services;

import com.example.entities.User;
import com.example.exceptions.UserException;
import com.example.paylode.AuthResponse;
import com.example.paylode.Login;

public interface UserServices {
    /**
     * This methode create new user
     * @param user
     * @return user
     */
    User creareUser(User user) ;

    /**
     * This methode use for login
     * @param login
     * @return User
     */
    AuthResponse loginUser(Login login);

    /**
     * This method find user by jwt token
     * @param jwt
     * @return user
     */
    User findUserByJwt(String jwt);

    /**
     * This method find user by id;
     * @param id
     * @return user
     */
    User findUserById(Integer id);

    /**
     * This method update existing user
     * @param id
     * @param user
     * @return updated user
     */
    User updateUser(Integer id , User user);
}

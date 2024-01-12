package com.example.services.impl;

import com.example.Repositories.UserRepository;
import com.example.config.JwtTokenProvider;
import com.example.entities.User;
import com.example.exceptions.AlreadyExistException;
import com.example.exceptions.ResourcesNotFoundException;
import com.example.paylode.AuthResponse;
import com.example.paylode.Login;
import com.example.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private CustomerDetailsService customerDetailsService;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CustomerDetailsService customerDetailsService, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.customerDetailsService = customerDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /**
     * This methode create new user
     * @param user
     * @return user
     */
    @Override
    public User creareUser(User user) {
        Optional<User> optional = userRepository.findByEmail(user.getEmail());
        if(optional.isPresent()) throw new AlreadyExistException("User already exist this email id " + user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * This methode use for login
     * @param login
     * @return User
     */
    @Override
    public AuthResponse loginUser(Login login) {
        Authentication authentication = authenticate(login.getUsername(), login.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.genrateToken(authentication);

        return AuthResponse.builder().token(token).message("Sign In Success").build();
    }

    /**
     * This method find user by jwt token
     * @param jwt
     * @return user
     */
    @Override
    public User findUserByJwt(String jwt) {
      String username =    jwtTokenProvider.getUsernameFromToakn(jwt);
      Optional<User> opt =  userRepository.findByEmail(username);
        User user = opt.orElseThrow(() -> new ResourcesNotFoundException("User not found with email " + username));
        System.out.println(user);
        return user;
    }

    /**
     * This method find user by id;
     * @param id
     * @return user
     */
    @Override
    public User findUserById(Integer id) {
        Optional<User> optional =  userRepository.findById(id);
        return optional.orElseThrow(()-> new ResourcesNotFoundException("User not found give id " + id));
    }

    /**
     * This method update existing user
     * @param id
     * @param user
     * @return updated user
     */
    @Override
    public User updateUser(Integer id, User user) {
        User existUser =  this.findUserById(id);
        existUser.setFirstName(user.getFirstName());
        existUser.setLastName(user.getLastName());
        existUser.setEmail(user.getEmail());
        existUser.setMobileNumber(user.getMobileNumber());
        existUser.setPassword(user.getPassword());

        return null;
    }

    private Authentication authenticate(String username, String password) {
        // TODO Auto-generated method stub
        UserDetails userDetails = customerDetailsService.loadUserByUsername(username);
        if (userDetails == null)
            throw new BadCredentialsException("Invalid Username");
        if (!passwordEncoder.matches(password, userDetails.getPassword()))
            throw new BadCredentialsException("Invalid Password");
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}

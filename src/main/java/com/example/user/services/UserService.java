package com.example.user.services;

import com.example.user.models.User;
import com.example.user.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    private UserRepositories userRepositories;
    @Autowired
    public UserService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public Optional<User> GetUserById(Long Id)
    {
//        Optional<User> userOptional = userRepositories.findById(Id);
//        User user;
//        if(userOptional.isPresent()){
//            //user.setName(userOptional.get);
//        }
        return userRepositories.findById(Id);
    }
    public User signUp(String email, String password) {
        Optional<User> userOptional = userRepositories.findByEmail(email);
        if(userOptional.isPresent()) {
            throw new RuntimeException();
        }
        User user = new User();
        user.setName("Meera");
        user.setEmail(email);
        user.setPassword(password);
//        Date currentDate = new Date();
//        user.setCreatedDate(currentDate);
        return userRepositories.save(user);

    }

}

package com.example.user.Controllers;

import com.example.user.models.User;
import com.example.user.dtos.ResponseStatus;
import com.example.user.dtos.UserRequestDto;
import com.example.user.dtos.UserResponseDto;
import com.example.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/SaveUserDetail")
    public ResponseEntity<UserResponseDto> SaveUserDetail(@RequestBody UserRequestDto request)
    {

        UserResponseDto userResponseDto = new UserResponseDto();
        User user;
        try{
            user = userService.signUp(request.getName(), request.getEmail(), request.getPassword());
            userResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            userResponseDto.setUserId(user.getId());
        }
        catch (Exception ex)
        {
            userResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return ResponseEntity.ok(userResponseDto);
    }
    @GetMapping("/GetUserbyId/{Id}")
    public Optional<User> GetUserbyId(@PathVariable Long Id)
    {
        Optional<User> user ;
        try
        {
            user = userService.GetUserById(Id);
        }
        catch (Exception ex) {
            throw new RuntimeException();
        }
        return user;
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}

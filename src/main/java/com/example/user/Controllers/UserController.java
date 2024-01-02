package com.example.user.Controllers;

import com.example.user.models.User;
import com.example.user.dtos.ResponseStatus;
import com.example.user.dtos.UserRequestDto;
import com.example.user.dtos.UserResponseDto;
import com.example.user.services.UserService;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    public UserResponseDto SignUp(UserRequestDto request)
    {
        UserResponseDto userResponseDto = new UserResponseDto();
        User user;
        try{
            user = userService.signUp(request.getEmail(), request.getPassword());
            userResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            userResponseDto.setUserId(user.getId());
        }
        catch (Exception ex)
        {
            userResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return userResponseDto;
    }
    public Optional<User> GetUserbyId(Long Id)
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
}

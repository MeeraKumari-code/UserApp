package com.example.user.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String email;
    private String Password;
    private String name;
}

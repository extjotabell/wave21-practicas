package com.example.RelacionesJpaW21.controller;

import com.example.RelacionesJpaW21.dto.UserDto;
import com.example.RelacionesJpaW21.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        return userService.insertUser(userDto);
    }
}

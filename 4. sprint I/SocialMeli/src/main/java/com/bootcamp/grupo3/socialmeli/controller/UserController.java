package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }
}

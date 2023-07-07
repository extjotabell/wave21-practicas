package com.example.RelacionesJpaW21.controller;

import com.example.RelacionesJpaW21.dto.UserDto;
import com.example.RelacionesJpaW21.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    IUserService userServ;

    public UserController(IUserService userServ) {
        this.userServ = userServ;
    }

    @PostMapping("/insertuser")
    public ResponseEntity<UserDto> insertUser(@RequestBody UserDto user){

        return ResponseEntity.ok(userServ.insertUser(user));

    }

}

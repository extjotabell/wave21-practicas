package com.example.RelacionesJpaW21.controller;

import com.example.RelacionesJpaW21.dto.UserDTO;
import com.example.RelacionesJpaW21.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    IUserService userService;

    UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    ResponseEntity<?> findAll() {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    ResponseEntity<?> getUser(@PathVariable final long id) {
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/user")
    ResponseEntity<?> createUser(@RequestBody UserDTO u) {
        return new ResponseEntity<>(this.userService.insertUser(u), HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    ResponseEntity<String> deleteUser(@PathVariable final long id) {
        this.userService.deleteUser(id);
        return new ResponseEntity<>("borrado", HttpStatus.OK);
    }
}

package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable(value = "userId") int userId,
                                    @PathVariable(value = "userIdToFollow") int userIdToFollow){
        return ResponseEntity.ok(userService.follow(userId,userIdToFollow));
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable(value = "userId") int userId,
                                    @PathVariable(value = "userIdToUnfollow") int userIdToUnfollow){
        return ResponseEntity.ok(userService.unfollow(userId,userIdToUnfollow));
    }
}

package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowerCountDTO;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowerCountDTO> getUserFollowers(@PathVariable int userId){
        return ResponseEntity.ok(userService.getUserFollowersCount(userId));
    }
}

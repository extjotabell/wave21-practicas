package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowedListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowersListDTO;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowedListDTO> getFollowed(@PathVariable int userId, @RequestParam(value = "order", required = false) String order){
        return ResponseEntity.ok().body(this.userService.getFollowed(userId, order));
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowersListDTO> getFollowers(@PathVariable int userId, @RequestParam(value = "order", required = false) String order){
        return ResponseEntity.ok().body(this.userService.getFollowers(userId, order));
    }
}

package com.example.be_java_hisp_w21_g02.controller;

import com.example.be_java_hisp_w21_g02.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g02.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService _userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?>  followUser(@PathVariable int userId, @PathVariable int userIdToFollow){
        _userService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnFollow}")
    public ResponseEntity<?>  unFollowUser(@PathVariable int userId, @PathVariable int userIdToUnFollow){
        _userService.unFollowUser(userId, userIdToUnFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable int userId){
        return new ResponseEntity<>(
                _userService.getFollowersCount(userId), HttpStatus.OK
        );
    }
}

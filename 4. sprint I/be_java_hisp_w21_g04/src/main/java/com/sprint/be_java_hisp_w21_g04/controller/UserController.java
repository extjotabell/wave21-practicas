package com.sprint.be_java_hisp_w21_g04.controller;

import com.sprint.be_java_hisp_w21_g04.dto.response.UserFollowResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserFollowersCountDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserUnfollowResponseDto;
import com.sprint.be_java_hisp_w21_g04.service.user.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sprint.be_java_hisp_w21_g04.dto.response.FollowersResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserResponseDto;
import org.springframework.http.HttpStatus;

@RestController
public class UserController {
    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserFollowResponseDto> userFollow(@PathVariable int userId, @PathVariable int userIdToFollow){
        return ResponseEntity.ok(userService.followUser(userId, userIdToFollow));
    }
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDto> userFollowersCountDto(@PathVariable int userId){
        return ResponseEntity.status(200).body(userService.getFollowersCount(userId));
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserUnfollowResponseDto> userUnfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersResponseDto> getFollowersById(@PathVariable int userId){
        return new ResponseEntity<>(userService.getFollowersById(userId), HttpStatus.OK);
    }

}

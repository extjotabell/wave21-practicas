package com.example.be_java_hisp_w21_g02.controller;

import com.example.be_java_hisp_w21_g02.service.IUsersService;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@Validated
public class UsersController {
    private final IUsersService _userService;

    public UsersController(IUsersService _userService) {
        this._userService = _userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable(value = "userId")
                                            @Positive(message = "User ID must be greater than zero")
                                            int userId,

                                        @PathVariable("userIdToFollow")
                                        @Positive(message = "User ID to follow must be greater than zero")
                                            int userIdToFollow){

        _userService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnFollow}")
    public ResponseEntity<?>  unFollowUser(@PathVariable
                                               @Positive(message = "User ID must be greater than zero")
                                               int userId,

                                           @PathVariable
                                           @Positive(message = "User ID to follow must be greater than zero")
                                           int userIdToUnFollow){

        _userService.unFollowUser(userId, userIdToUnFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable
                                                   @Positive(message = "User ID must be greater than zero")
                                                   int userId){

        return new ResponseEntity<>(_userService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersList(@PathVariable("userId")
                                                  @Positive(message = "User ID must be greater than zero")
                                                  int userId,

                                              @RequestParam(required = false)
                                              String order){

        return new ResponseEntity<>( _userService.getFollowersList(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowedist(@PathVariable
                                                @Positive(message = "User ID must be greater than zero")
                                                int userId,

                                            @RequestParam(required = false)
                                            String order){

        return new ResponseEntity<>( _userService.getFollowedList(userId, order), HttpStatus.OK);
    }
}

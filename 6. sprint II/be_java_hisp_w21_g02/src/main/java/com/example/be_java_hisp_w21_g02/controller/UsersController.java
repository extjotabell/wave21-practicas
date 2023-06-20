package com.example.be_java_hisp_w21_g02.controller;

import com.example.be_java_hisp_w21_g02.dto.response.FollowedListDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersListDTO;
import com.example.be_java_hisp_w21_g02.exceptions.OrderNotFoundException;
import com.example.be_java_hisp_w21_g02.service.IUsersService;
import com.example.be_java_hisp_w21_g02.utils.Constants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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

    // @Min(value = 1, message = "The id must be greater than zero")
    //@Size(min = 1, message = "The id must be greater than zero")
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable("userId") @Positive(message = "User ID must be greater than zero")
                                            Integer userId,
                                        @PathVariable("userIdToFollow") @Positive(message = "User ID to follow must be greater than zero")
                                            Integer userIdToFollow){
        _userService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnFollow}")
    public ResponseEntity<?>  unFollowUser(@PathVariable @Positive(message = "User ID must be greater than zero") int userId, @PathVariable @Positive(message = "User ID to follow must be greater than zero") int userIdToUnFollow){
        _userService.unFollowUser(userId, userIdToUnFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable int userId){
        return new ResponseEntity<>(
                _userService.getFollowersCount(userId), HttpStatus.OK
        );
    }
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersList(@PathVariable("userId") @Positive(message = "User ID must be greater than zero") int userId, @RequestParam(required = false) String order){
        if (order != null && !Constants.isOrderConstant(order))
            throw new OrderNotFoundException("The order type does not exist");

        FollowersListDTO followersListDTO;
        if (order != null)
            followersListDTO =  _userService.getFollowersList(userId, order);
        else
            followersListDTO = _userService.getFollowersList(userId);

        return new ResponseEntity<>(followersListDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowedist(@PathVariable @Positive(message = "User ID must be greater than zero") int userId, @RequestParam(required = false) String order){
        if (order != null && !Constants.isOrderConstant(order))
            throw new OrderNotFoundException("The order type does not exist");

        FollowedListDTO followedListDTO;
        if (order != null)
            followedListDTO =  _userService.getFollowedList(userId, order);
        else
            followedListDTO = _userService.getFollowedList(userId);
        return new ResponseEntity<> (followedListDTO, HttpStatus.OK);
    }
}

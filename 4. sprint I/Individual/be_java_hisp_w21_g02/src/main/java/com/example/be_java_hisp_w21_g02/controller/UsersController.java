package com.example.be_java_hisp_w21_g02.controller;

import com.example.be_java_hisp_w21_g02.dto.response.FollowedListDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersListDTO;
import com.example.be_java_hisp_w21_g02.exceptions.OrderNotFoundException;
import com.example.be_java_hisp_w21_g02.service.IUsersService;
import com.example.be_java_hisp_w21_g02.utils.Constants;
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
    public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow){
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
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersList(@PathVariable int userId, @RequestParam(required = false) String order){
        if (order != null && !Constants.isOrderConstant(order))
            throw new OrderNotFoundException("El tipo de ordenamiento no existe");

        FollowersListDTO followersListDTO;
        if (order != null)
            followersListDTO =  _userService.getFollowersList(userId, order);
        else
            followersListDTO = _userService.getFollowersList(userId);

        return new ResponseEntity<>(followersListDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowedist(@PathVariable int userId, @RequestParam(required = false) String order){
        if (order != null && !Constants.isOrderConstant(order))
            throw new OrderNotFoundException("El tipo de ordenamiento no existe");

        FollowedListDTO followedListDTO;
        if (order != null)
            followedListDTO =  _userService.getFollowedList(userId, order);
        else
            followedListDTO = _userService.getFollowedList(userId);
        return new ResponseEntity<> (followedListDTO, HttpStatus.OK);
    }


}

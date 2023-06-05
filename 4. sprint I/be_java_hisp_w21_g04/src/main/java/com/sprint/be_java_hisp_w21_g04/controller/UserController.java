package com.sprint.be_java_hisp_w21_g04.controller;

import com.sprint.be_java_hisp_w21_g04.dto.response.FollowersResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserResponseDto;
import com.sprint.be_java_hisp_w21_g04.service.user.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {

    private IUserService _userService;

    public UserController(IUserService userService) {
        this._userService = userService;
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<?> getFollowersById(@PathVariable int userId){
        FollowersResponseDto followers = _userService.getFollowersById(userId);
        return new ResponseEntity<>(followers, HttpStatus.OK);
    }

}

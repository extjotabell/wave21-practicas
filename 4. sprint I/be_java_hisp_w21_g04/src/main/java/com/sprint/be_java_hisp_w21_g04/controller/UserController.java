package com.sprint.be_java_hisp_w21_g04.controller;

import com.sprint.be_java_hisp_w21_g04.dto.response.FollowedResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.FollowersResponseDto;
import com.sprint.be_java_hisp_w21_g04.service.user.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private IUserService _userService;

    public UserController(IUserService userService) {
        this._userService = userService;
    }

    /*@GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersResponseDto> getFollowersById(@PathVariable int userId){
        return new ResponseEntity<>(_userService.getFollowersById(userId), HttpStatus.OK);
    }*/

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersResponseDto> getFollowersByIdSorted(@PathVariable ("userId") int userId,
                                                                       @RequestParam (value = "order",required = false) String order){
        if(order == null){
            return new ResponseEntity<>(_userService.getFollowersById(userId), HttpStatus.OK);
        }
        return new ResponseEntity<>(_userService.getFollowersByIdSorted(userId,order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedResponseDto> getFollowedById(@PathVariable ("userId") int userId,
                                                               @RequestParam ("order") String order){
        return new ResponseEntity<>(_userService.getFollowedById(userId), HttpStatus.OK);
    }

}

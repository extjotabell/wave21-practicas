package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowedListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowersListDTO;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowerCountDTO;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDTO> follow(@PathVariable(value = "userId") int userId,
                                             @PathVariable(value = "userIdToFollow") int userIdToFollow){
        return ResponseEntity.ok(userService.follow(userId,userIdToFollow));
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageDTO> unfollow(@PathVariable(value = "userId") int userId,
                                               @PathVariable(value = "userIdToUnfollow") int userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollow(userId, userIdToUnfollow));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedListDTO> getFollowed(@PathVariable int userId,
                                                           @RequestParam(value = "order", required = false) String order){
        return ResponseEntity.ok().body(this.userService.getFollowed(userId, order));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersListDTO> getFollowers(@PathVariable int userId,
                                                             @RequestParam(value = "order", required = false) String order) {
        return ResponseEntity.ok().body(this.userService.getFollowers(userId, order));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowerCountDTO> getUserFollowers(@PathVariable int userId){
        return ResponseEntity.ok(userService.getUserFollowersCount(userId));
    }
}

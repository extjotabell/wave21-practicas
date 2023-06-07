package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.request.LoginDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserIdDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.*;
import com.bootcamp.grupo3.socialmeli.exception.UserPermissionException;
import com.bootcamp.grupo3.socialmeli.order.UserOrderType;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("/{token}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDTO> follow(
      @PathVariable String token,
      @PathVariable(value = "userIdToFollow") int userIdToFollow
    ) throws UserPermissionException {
        return ResponseEntity.ok(userService.follow(token, userIdToFollow));
    }

    @PostMapping("/{token}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageDTO> unfollow(
      @PathVariable String token,
      @PathVariable(value = "userIdToUnfollow") int userIdToUnfollow
    ) throws UserPermissionException {
        return ResponseEntity.ok(userService.unfollow(token, userIdToUnfollow));
    }

    @GetMapping("/{token}/followed/list")
    public ResponseEntity<UserFollowedListDTO> getFollowed(
      @PathVariable String token,
      @RequestParam(value = "order", required = false) String order
    ) throws UserPermissionException {
        return ResponseEntity.ok().body(this.userService.getFollowed(token, order));
    }

    @GetMapping("/{token}/followers/list")
    public ResponseEntity<UserFollowersListDTO> getFollowers(
      @PathVariable final String token,
      @RequestParam final Optional<String> order
    ) throws UserPermissionException {

        UserOrderType o = order
          .map(UserOrderType::getEnumValue)
          .orElse(UserOrderType.DEFAULT);

        return ResponseEntity.ok().body(this.userService.getFollowers(token, o));
    }

    @GetMapping("/{token}/followers/count")
    public ResponseEntity<UserFollowerCountDTO> getUserFollowers(@PathVariable String token)
    throws UserPermissionException {
        return ResponseEntity.ok(userService.getUserFollowersCount(token));
    }

    @PostMapping("/")
    public ResponseEntity<UserIdDTO> createUser(@RequestBody  final UserPasswordDTO u) {
      UserIdDTO user = userService.createUser(u);
      return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody final LoginDTO login) {
      TokenDTO token = userService.validateUser(login);
      return ResponseEntity.ok(token);
    }
}

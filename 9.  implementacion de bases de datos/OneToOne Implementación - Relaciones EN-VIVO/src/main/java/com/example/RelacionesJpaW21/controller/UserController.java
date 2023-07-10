package com.example.RelacionesJpaW21.controller;

import com.example.RelacionesJpaW21.entity.OneToOne.User;
import com.example.RelacionesJpaW21.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody User user){
        User response = service.insertUser(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<User> response = service.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        service.deleteUser(id);
        return new ResponseEntity<>("Eliminado",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }
}

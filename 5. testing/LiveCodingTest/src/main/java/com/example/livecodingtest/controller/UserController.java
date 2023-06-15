package com.example.livecodingtest.controller;

import com.example.livecodingtest.dto.ResponseDto;
import com.example.livecodingtest.dto.TestPostDto;
import com.example.livecodingtest.dto.UserDto;
import com.example.livecodingtest.service.IUserService;
import com.example.livecodingtest.service.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    IUserService userService;

    public UserController(UserServiceImp userService){
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.crearUsuario(userDto),HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> obtenerTodos(){
        return new ResponseEntity<>(userService.buscarTodos(), HttpStatus.OK);
    }

    //------------------------------------------------------------------------------------------------------

    @GetMapping("/sayHello")
    public ResponseEntity<?> sayHello(){
       return new ResponseEntity<>(new ResponseDto(1,"Hello World"),HttpStatus.OK);
    }

    @GetMapping("/sayHello/{name}")
    public ResponseEntity<?> sayHello(@PathVariable String name){
        String message = "Hello " + name;
        return new ResponseEntity<>(new ResponseDto(1,message),HttpStatus.OK);
    }

    @GetMapping("/sayHello2")
    public ResponseEntity<?> sayHelloRP(@RequestParam String name){
        String message = "Hello "+ name;
        return new ResponseEntity<>(new ResponseDto(1,message),HttpStatus.OK);
    }

    @PostMapping("/postHello")
    public ResponseEntity<?> sayHelloPost(@RequestBody TestPostDto testPostDto){

        String message = "Hello "+ testPostDto.getName();
        ResponseDto response = new ResponseDto(1,message);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}

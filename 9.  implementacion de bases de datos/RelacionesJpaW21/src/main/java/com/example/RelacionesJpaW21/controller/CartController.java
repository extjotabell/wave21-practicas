package com.example.RelacionesJpaW21.controller;

import com.example.RelacionesJpaW21.dto.CartDto;
import com.example.RelacionesJpaW21.service.CartServiceImp;
import com.example.RelacionesJpaW21.service.ICartService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    ICartService cartService;

    public CartController(CartServiceImp cartService){
        this.cartService = cartService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getCarts(){
        return new ResponseEntity<>(cartService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCart(@RequestBody CartDto cartDto){
        return new ResponseEntity<>(cartService.insertCart(cartDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCart(@PathVariable Long id){
        return new ResponseEntity<>(cartService.deleteCart(id),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(cartService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCart(){
        return null;
    }
}

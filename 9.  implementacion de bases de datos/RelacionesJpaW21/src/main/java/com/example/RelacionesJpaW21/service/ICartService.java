package com.example.RelacionesJpaW21.service;

import com.example.RelacionesJpaW21.dto.CartDto;
import com.example.RelacionesJpaW21.dto.RespCartDto;

import java.util.List;

public interface ICartService {
    List<CartDto> findAll();
    RespCartDto insertCart(CartDto cartDto);
    RespCartDto deleteCart(Long id);
    CartDto findById(Long id);
}

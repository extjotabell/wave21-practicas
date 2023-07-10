package com.example.RelacionesJpaW21.service;


import com.example.RelacionesJpaW21.dto.CartDto;
import com.example.RelacionesJpaW21.dto.RespCartDto;
import com.example.RelacionesJpaW21.entity.OneToMany.Cart;
import com.example.RelacionesJpaW21.repository.ICartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImp implements ICartService{

    ICartRepository cartRepository;

    public CartServiceImp(ICartRepository cartRepository){
        this.cartRepository= cartRepository;
    }
    @Override
    public List<CartDto> findAll() {
        ModelMapper mapper = new ModelMapper();

        List<Cart> carts = cartRepository.findAll();

        List<CartDto> cartDtos = new ArrayList<>();

        carts.stream().forEach( c -> cartDtos.add(mapper.map(c,CartDto.class)));

        return cartDtos;
    }

    @Override
    public RespCartDto insertCart(CartDto cartDto) {
        ModelMapper mapper = new ModelMapper();

        Cart cart = mapper.map(cartDto, Cart.class);
        cart.getItems().forEach(i-> i.setCart(cart));

        Cart persistCart = cartRepository.save(cart);

        RespCartDto response = new RespCartDto();
        response.setCart(mapper.map(persistCart,CartDto.class));
        response.setMessage("Guardado con éxito...");

        return response;
    }

    @Override
    public RespCartDto deleteCart(Long id) {
        cartRepository.deleteById(id);
        RespCartDto resp = new RespCartDto();
        resp.setMessage("se borró...");
        return resp;
    }

    @Override
    public CartDto findById(Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Cart> cart = cartRepository.findById(id);
        if(!cart.isPresent()){
            throw new RuntimeException("no existe");
        }

        CartDto response = mapper.map(cart,CartDto.class);
        return response;
    }
}

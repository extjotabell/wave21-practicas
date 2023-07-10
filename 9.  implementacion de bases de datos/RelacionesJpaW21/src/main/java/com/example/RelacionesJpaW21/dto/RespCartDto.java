package com.example.RelacionesJpaW21.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RespCartDto {
    private CartDto cart;
    private String message;
}

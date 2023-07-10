package com.example.RelacionesJpaW21.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private AddressDto address;
}

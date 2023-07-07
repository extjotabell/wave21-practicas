package com.example.RelacionesJpaW21.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private AddressDTO address;
}

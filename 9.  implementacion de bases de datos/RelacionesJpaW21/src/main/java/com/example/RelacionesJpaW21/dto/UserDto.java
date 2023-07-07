package com.example.RelacionesJpaW21.dto;

import com.example.RelacionesJpaW21.entity.OneToOne.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserDto {

    private Long id;
    private String name;
    private Address address;
}

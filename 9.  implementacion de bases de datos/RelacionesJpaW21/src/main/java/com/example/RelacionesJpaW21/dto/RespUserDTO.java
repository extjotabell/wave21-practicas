package com.example.RelacionesJpaW21.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespUserDTO {
    private UserDTO user;
    private String message;
}

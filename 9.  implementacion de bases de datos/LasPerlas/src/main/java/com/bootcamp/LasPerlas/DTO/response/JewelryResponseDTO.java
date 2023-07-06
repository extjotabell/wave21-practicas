package com.bootcamp.LasPerlas.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class JewelryResponseDTO {
    int statusCode;
    List<JewelDTO> jewels;
}

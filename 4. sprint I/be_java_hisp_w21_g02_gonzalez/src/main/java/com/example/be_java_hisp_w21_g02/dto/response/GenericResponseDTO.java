package com.example.be_java_hisp_w21_g02.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class GenericResponseDTO {
    //INDIVIDUAL US0010
    //INDIVIDUAL US0011
    //INDIVIDUAL BONUS
    private int statusCode;
    private String message;
}
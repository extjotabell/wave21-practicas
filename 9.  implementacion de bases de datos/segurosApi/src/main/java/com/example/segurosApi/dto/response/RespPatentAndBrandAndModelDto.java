package com.example.segurosApi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespPatentAndBrandAndModelDto {
    private String patent;
    private String marca;
    private String modelo;
}

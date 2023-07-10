package com.example.segurosApi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class RespPatentAndBrandAndModelDto {
    private String patent;
    private String marca;
    private String modelo;
}

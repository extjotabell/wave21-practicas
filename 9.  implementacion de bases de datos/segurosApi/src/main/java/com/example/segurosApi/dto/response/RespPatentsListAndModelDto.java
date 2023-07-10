package com.example.segurosApi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespPatentsListAndModelDto {
    String patente;
    String modelo;

}

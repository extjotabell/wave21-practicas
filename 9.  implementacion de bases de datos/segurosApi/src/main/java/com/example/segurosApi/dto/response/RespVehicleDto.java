package com.example.segurosApi.dto.response;

import com.example.segurosApi.dto.VehiculoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespVehicleDto {
    private String message;
    private VehiculoDto vehiculoDto;
}

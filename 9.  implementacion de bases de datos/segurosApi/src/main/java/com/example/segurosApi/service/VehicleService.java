package com.example.segurosApi.service;

import com.example.segurosApi.dto.VehiculoDto;
import com.example.segurosApi.dto.response.RespVehicleDto;
import com.example.segurosApi.model.Vehiculo;

import java.util.List;

public interface VehicleService {
    List<VehiculoDto> getAllVehicle();
    RespVehicleDto saveVehicle(VehiculoDto dto);
    RespVehicleDto deleteCart(Long id);
    RespVehicleDto getVehicleById(Long id);
    RespPatentsListDto getAllPlates();
    List<RespPatentAndBrandAndModelDto> getAllPatentAndBrandAndModel();
}

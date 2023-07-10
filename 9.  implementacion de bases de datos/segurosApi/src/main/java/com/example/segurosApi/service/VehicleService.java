package com.example.segurosApi.service;

import com.example.segurosApi.dto.VehiculoDto;
import com.example.segurosApi.dto.response.RespPatentAndBrandAndModelDto;
import com.example.segurosApi.dto.response.RespPatentsListAndModelDto;
import com.example.segurosApi.dto.response.RespPatentsListDto;
import com.example.segurosApi.dto.response.RespVehicleDto;

import java.util.List;

public interface VehicleService {
    List<VehiculoDto> getAllVehicle();
    RespVehicleDto saveVehicle(VehiculoDto dto);
    RespVehicleDto deleteCart(Long id);
    RespVehicleDto getVehicleById(Long id);
    RespPatentsListDto getAllPatents();
    List<RespPatentAndBrandAndModelDto> getAllPatentAndBrandAndModel();
    List<RespPatentsListAndModelDto> getAllVehicleOrdenByManufacturing();
}

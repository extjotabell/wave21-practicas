package com.example.segurosApi.service;

import com.example.segurosApi.dto.VehiculoDto;
import com.example.segurosApi.dto.response.RespPatentAndBrandAndModelDto;
import com.example.segurosApi.dto.response.RespPatentsListAndModelDto;
import com.example.segurosApi.dto.response.RespPatentsListDto;
import com.example.segurosApi.dto.response.RespVehicleDto;
import com.example.segurosApi.model.Vehiculo;
import com.example.segurosApi.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

@Service
public class VehicleServiceImpl implements VehicleService {

    ModelMapper mapper;
    VehicleRepository vehicleRepository;
    VehicleServiceImpl(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
        this.mapper = new ModelMapper();
    }
    @Override
    public RespPatentsListDto getAllPatents(){
        List<String> listOfPlates = vehicleRepository.findAllPatents();
        return new RespPatentsListDto(listOfPlates);
    }

    @Override
    public List<RespPatentAndBrandAndModelDto> getAllPatentAndBrandAndModel() {
        List<Vehiculo> response = vehicleRepository.findAllPatentAndBrandAndModel();
        List<RespPatentAndBrandAndModelDto> dto = new ArrayList<>();
        response.stream()
                .forEach(v -> dto.add(new RespPatentAndBrandAndModelDto(
                        v.getPatente(),
                        v.getMarca(),
                        v.getModelo()
                )));
        return dto;
    }

    @Override
    public List<VehiculoDto> getAllVehicle() {
        List<Vehiculo> vehicles = vehicleRepository.findAll();
        List<VehiculoDto> vehiclesDtos = new ArrayList<>();
        vehicles.stream().forEach(v -> vehiclesDtos.add(mapper.map(v, VehiculoDto.class)));
        return vehiclesDtos;
    }

    @Override
    public RespVehicleDto saveVehicle(VehiculoDto dto) {
        Vehiculo vehiculo = mapper.map(dto, Vehiculo.class);
        Vehiculo vehiculoSaved;
        try{
            vehiculo.getSiniestros()
                    .forEach(s -> s.setVehiculo(vehiculo));
            vehiculoSaved = vehicleRepository.save(vehiculo);
        }
        catch (Exception e){
            throw new RuntimeException("Algo pasa... " + e.getMessage());
        }


        return new RespVehicleDto("Vehiculo guardado con exito", mapper.map(vehiculoSaved, VehiculoDto.class));
    }

    @Override
    public RespVehicleDto deleteCart(Long id) {
        vehicleRepository.deleteById(id);
        return new RespVehicleDto("Vehiculo eliminado exito", null);
    }

    @Override
    public RespVehicleDto getVehicleById(Long id){
        Optional<Vehiculo> persistedVehicle =  vehicleRepository.findById(id);

        if (!persistedVehicle.isPresent()) {
            throw new RuntimeException("Algo pasa... " + "El vehiculo con el ID ingresado no existe");
        }

        return new RespVehicleDto("", mapper.map(persistedVehicle, VehiculoDto.class));
    }
    @Override
    public List<RespPatentsListAndModelDto> getAllVehicleOrdenByManufacturing(){
        List<Vehiculo> persistedVehicleList = vehicleRepository.findAllVehicleOrdenByManufacturing();
        List<RespPatentsListAndModelDto> dto = new ArrayList<>();

        persistedVehicleList
                .forEach(v -> dto.add(new RespPatentsListAndModelDto(v.getPatente(), v.getModelo())));

        return dto;
    }
}

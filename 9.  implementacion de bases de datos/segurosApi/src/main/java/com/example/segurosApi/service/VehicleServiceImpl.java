package com.example.segurosApi.service;

import com.example.segurosApi.dto.VehiculoDto;
import com.example.segurosApi.dto.response.RespVehicleDto;
import com.example.segurosApi.model.Vehiculo;
import com.example.segurosApi.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

        return null;
    }


}

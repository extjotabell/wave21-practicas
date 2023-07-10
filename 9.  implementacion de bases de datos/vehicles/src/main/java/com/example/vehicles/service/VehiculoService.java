package com.example.vehicles.service;

import com.example.vehicles.entity.Vehiculo;
import com.example.vehicles.repository.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository){
        this.vehiculoRepository=vehiculoRepository;
    }

    public Vehiculo agregarVehiculo(Vehiculo vehiculo){
        Vehiculo vehiculo1 = vehiculoRepository.save(vehiculo);
        return vehiculo1;
    }

    public List<Vehiculo> listarVehiculos(){
        return vehiculoRepository.findAll();
    }

    public List<String> listarPatentes(){
        return vehiculoRepository.findPatentes();
    }
}

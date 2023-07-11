package com.bootcamp.autos.service;

import com.bootcamp.autos.dto.*;
import com.bootcamp.autos.entity.Siniestro;
import com.bootcamp.autos.entity.Vehiculo;
import com.bootcamp.autos.exception.VehiculoNotFoundException;
import com.bootcamp.autos.repository.IVehiculoRepository;
import com.bootcamp.autos.repository.template.PatenteYModeloTemplate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VehiculoServiceImp implements IVehiculoService{

    private final IVehiculoRepository vehiculoRepository;
    private final ModelMapper mapper;
    public VehiculoServiceImp(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public VehiculoDTO saveCar(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = mapper.map(vehiculoDTO, Vehiculo.class);
        vehiculo.setSiniestros(new HashSet<>());
        VehiculoDTO response = mapper.map(vehiculoRepository.save(vehiculo),VehiculoDTO.class);
        response.setMessage("Vehiculo registrado con exito");
        return response;
    }

    @Override
    public ListVehiculoDTO findAll() {
        List<VehiculoDTO> response = vehiculoRepository.findAll()
                .stream()
                .map(m-> mapper.map(m,VehiculoDTO.class))
                .toList();

        return new ListVehiculoDTO(response);
    }

    @Override
    public VehiculoDTO findById(Long id) {

        return mapper.map(vehiculoRepository.findById(id)
                     .orElseThrow(()->new VehiculoNotFoundException("no se encuentra el vehiculo"))
                     ,VehiculoDTO.class);
    }

    @Override
    public VehiculoDTO deleteCar(Long id) {
        Vehiculo carToDelete = vehiculoRepository.findById(id)
                                     .orElseThrow(()->new VehiculoNotFoundException("No se encuentra el vehiculo"));
        vehiculoRepository.delete(carToDelete);
        return mapper.map(carToDelete,VehiculoDTO.class);
    }

    @Override
    public ListVehiculoPatenteDTO findByPatente() {
        return new ListVehiculoPatenteDTO(vehiculoRepository.findPatente());
    }

    @Override
    public ListPatenteYModeloDTO findPatenteAndMarceOrderByAnioFabricacion() {

        List<PatenteYModeloTemplate> vehiculos = vehiculoRepository.findPatenteAndMarceOrderByAnioFabricacion();

        return new ListPatenteYModeloDTO(vehiculos.stream()
                .map(m->mapper.map(m, PatenteModeloVehiculoDTO.class))
                .toList()
        );

    }

    @Override
    public List<PatenteMarcaModeloDTO> findCarWithElevateEconomicLost() {
        return  vehiculoRepository.findVehiculoByPerdidasEconomicas().stream()
                                        .map(m->mapper.map(m,PatenteMarcaModeloDTO.class))
                                        .toList();
    }
}

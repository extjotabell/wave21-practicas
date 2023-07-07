package com.bootcamp.autos.service;

import com.bootcamp.autos.dto.ListMarcaModeloVehiculoDTO;
import com.bootcamp.autos.dto.ListVehiculoDTO;
import com.bootcamp.autos.dto.VehiculoDTO;
import com.bootcamp.autos.entity.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    VehiculoDTO saveCar(VehiculoDTO vehiculoDTO);
    ListVehiculoDTO findAll();
    VehiculoDTO findById();
    VehiculoDTO deleteCar (Long id);
    List<String> findByPatente();

    List<ListMarcaModeloVehiculoDTO> findPatenteAndMarceOrderByAnioFabricacion();
}

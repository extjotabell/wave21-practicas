package com.bootcamp.autos.service;

import com.bootcamp.autos.dto.*;

import java.util.List;

public interface IVehiculoService {

    VehiculoDTO saveCar(VehiculoDTO vehiculoDTO);
    ListVehiculoDTO findAll();
    VehiculoDTO findById(Long id);
    VehiculoDTO deleteCar (Long id);
    ListVehiculoPatenteDTO findByPatente();

    ListPatenteYModeloDTO findPatenteAndMarceOrderByAnioFabricacion();

    List<PatenteMarcaModeloDTO> findCarWithElevateEconomicLost();
}

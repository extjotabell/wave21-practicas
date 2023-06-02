package com.bootcamp.concesionariadeautosoptionalenvivo.service;

import com.bootcamp.concesionariadeautosoptionalenvivo.dto.request.VehicleRequestDTO;
import com.bootcamp.concesionariadeautosoptionalenvivo.dto.response.VehicleResponseDTO;
import java.util.List;

public interface IConcessionaireService {
    String create(VehicleRequestDTO vehicleRequestDTO);

    List<VehicleResponseDTO> getVehicles();

    List<VehicleResponseDTO> getVehiclesSinceTo(String since, String to);

    List<VehicleResponseDTO> getVehiclesPrices(String since, String to);

    VehicleResponseDTO getVehicleById(String id);
}
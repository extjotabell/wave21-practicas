package com.bootcamp.concesionariadeautosoptionalenvivo.service;

import com.bootcamp.concesionariadeautosoptionalenvivo.dto.request.VehicleRequestDTO;
import com.bootcamp.concesionariadeautosoptionalenvivo.dto.response.VehicleResponseDTO;
import com.bootcamp.concesionariadeautosoptionalenvivo.model.Vehicle;
import com.bootcamp.concesionariadeautosoptionalenvivo.repository.IConcessionaireRepository;
import com.bootcamp.concesionariadeautosoptionalenvivo.utils.ConcessionaireUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ConcessionaireService implements IConcessionaireService {

    @Autowired
    IConcessionaireRepository concessionaireRepository;

    private static final String CREATED_SUCCESS = "Vehicle created successfully";

    @Override
    public String create(VehicleRequestDTO vehicleRequestDTO) {
        concessionaireRepository.createVehicle(ConcessionaireUtils
                .convertFromVehicleDTOToVehicle(vehicleRequestDTO));
        return CREATED_SUCCESS;
    }

    @Override
    public List<VehicleResponseDTO> getVehicles() {
        List<VehicleResponseDTO> result = new ArrayList<>();
        concessionaireRepository.getAllVehicles().forEach(vehicle -> {
            result.add(ConcessionaireUtils.convertFromVehicleToVehicleDTO(vehicle));
        });
        return result;
    }

    @Override
    public List<VehicleResponseDTO> getVehiclesSinceTo(String since, String to) {
        List<VehicleResponseDTO> result = new ArrayList<>();
        concessionaireRepository.getAllVehicles().forEach(vehicle -> {
            if(Objects.requireNonNull(ConcessionaireUtils.convertStringToLocalDateTime(since)).isBefore(vehicle.getManufacturingDate()) &&
                    Objects.requireNonNull(ConcessionaireUtils.convertStringToLocalDateTime(to)).isAfter(vehicle.getManufacturingDate())){
                result.add(ConcessionaireUtils.convertFromVehicleToVehicleDTO(vehicle));
            }
        });
        return result;
    }

    @Override
    public List<VehicleResponseDTO> getVehiclesPrices(String since, String to) {
        List<VehicleResponseDTO> result = new ArrayList<>();
        concessionaireRepository.getAllVehicles().forEach(vehicle -> {
            if(Double.parseDouble(since) < vehicle.getPrice() && Double.parseDouble(to) > vehicle.getPrice()){
                result.add(ConcessionaireUtils.convertFromVehicleToVehicleDTO(vehicle));
            }
        });
        return result;
    }

    @Override
    public VehicleResponseDTO getVehicleById(String id) {
        Vehicle vehicle = concessionaireRepository.getAllVehicles().stream()
                .filter(v -> String.valueOf(v.getId()).equals(id)).findAny().orElse(null);
        return vehicle != null ? ConcessionaireUtils.convertFromVehicleToVehicleDTO(vehicle) : null;
    }
}
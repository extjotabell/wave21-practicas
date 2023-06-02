package com.bootcamp.concesionariadeautosoptionalenvivo.utils;

import com.bootcamp.concesionariadeautosoptionalenvivo.dto.request.VehicleRequestDTO;
import com.bootcamp.concesionariadeautosoptionalenvivo.dto.response.VehicleResponseDTO;
import com.bootcamp.concesionariadeautosoptionalenvivo.model.Service;
import com.bootcamp.concesionariadeautosoptionalenvivo.model.Vehicle;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ConcessionaireUtils {

    public static Vehicle convertFromVehicleDTOToVehicle(VehicleRequestDTO vehicleRequestDTO){
        List<Service> services = Arrays.stream(vehicleRequestDTO.getServices()).map(serviceDTO -> {
            String[] asf = serviceDTO.getDate().split("-");
            Service service = new Service();
            service.setDate(convertStringToLocalDateTime(serviceDTO.getDate()));
            service.setDescriptions(serviceDTO.getDescriptions());
            service.setKilometers(Integer.parseInt(serviceDTO.getKilometers()));
            return service;
        }).toList();

        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleRequestDTO.getBrand());
        vehicle.setModel(vehicleRequestDTO.getModel());
        vehicle.setManufacturingDate(convertStringToLocalDateTime(vehicleRequestDTO.getManufacturingDate()));
        vehicle.setNumberOfKilometers(Integer.parseInt(vehicleRequestDTO.getNumberOfKilometers()));
        vehicle.setDoors(Integer.parseInt(vehicleRequestDTO.getDoors()));
        vehicle.setPrice(Double.parseDouble(vehicleRequestDTO.getPrice()));
        vehicle.setCurrency(vehicleRequestDTO.getCurrency());
        vehicle.setServices(services);
        vehicle.setCountOfOwners(Integer.parseInt(vehicleRequestDTO.getCountOfOwners()));
        return vehicle;
    }

    public static VehicleResponseDTO convertFromVehicleToVehicleDTO(Vehicle vehicle){
        VehicleResponseDTO vehicleDTO = new VehicleResponseDTO();
        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        vehicleDTO.setDoors(vehicle.getDoors());
        vehicleDTO.setPrice(vehicle.getPrice());
        vehicleDTO.setCurrency(vehicle.getCurrency());
        vehicleDTO.setCountOfOwners(vehicle.getCountOfOwners());
        return vehicleDTO;
    }

    public static LocalDateTime convertStringToLocalDateTime(String dateText){
        String[] parts = dateText.split("-");
        if(parts.length > 2){
            return LocalDateTime.of(toInt(parts[0]), toInt(parts[1]), toInt(parts[2]), 0, 0);
        }
        return null;
    }

    private static int toInt(String number){
        return Integer.parseInt(number);
    }
}

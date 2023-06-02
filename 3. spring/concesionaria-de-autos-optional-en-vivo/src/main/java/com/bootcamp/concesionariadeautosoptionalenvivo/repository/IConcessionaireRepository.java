package com.bootcamp.concesionariadeautosoptionalenvivo.repository;

import com.bootcamp.concesionariadeautosoptionalenvivo.model.Vehicle;

import java.util.List;

public interface IConcessionaireRepository {
    void createVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();
}

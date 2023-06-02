package com.bootcamp.concesionariadeautosoptionalenvivo.repository;

import com.bootcamp.concesionariadeautosoptionalenvivo.model.Vehicle;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConcessionaireRepository implements IConcessionaireRepository {

    private List<Vehicle> vehicles;
    public ConcessionaireRepository(){
        vehicles = new ArrayList<>();
    }
    @Override
    public void createVehicle(Vehicle vehicle) {
        vehicle.setId(!vehicles.isEmpty() ? vehicles.get(vehicles.size() -1).getId() + 1  : 1);
        vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }
}
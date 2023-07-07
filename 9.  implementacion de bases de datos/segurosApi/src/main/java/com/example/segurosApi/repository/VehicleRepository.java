package com.example.segurosApi.repository;

import com.example.segurosApi.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehiculo, Long> {

}

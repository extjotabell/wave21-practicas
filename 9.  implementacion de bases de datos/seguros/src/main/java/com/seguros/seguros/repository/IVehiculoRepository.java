package com.seguros.seguros.repository;

import com.seguros.seguros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    //@Query("select v.patente, v.marca from Vehiculo v order by v.anioFabricacion")
    // findPateteAndMarcaOrderByAnioFabricacion(Integer anioFabricacion);


}

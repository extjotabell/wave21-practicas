package com.example.segurosApi.repository;

import com.example.segurosApi.dto.response.RespPatentAndBrandAndModelDto;
import com.example.segurosApi.dto.response.RespPatentsListAndModelDto;
import com.example.segurosApi.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatents();

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("SELECT v.patente, v.modelo FROM Vehiculo v ORDER BY v.fabricacion")
    List<RespPatentsListAndModelDto> findAllPatentsAndModel();

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantRuedas > 4 AND YEAR(v.fabricacion) = YEAR(current_date)")
    List<String> findAllPatentsByCantRuedasAndCurrentYear();

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v WHERE v.id IN (SELECT s.vehiculo.id FROM v.siniestros s WHERE s.perdidaEconomica > 10000 ) ")
    List<RespPatentAndBrandAndModelDto> findAllPatentAndBrandAndModel();

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
}

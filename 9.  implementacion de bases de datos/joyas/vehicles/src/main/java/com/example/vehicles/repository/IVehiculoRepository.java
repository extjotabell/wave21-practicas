package com.example.vehicles.repository;

import com.example.vehicles.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Integer> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<String> listarPatentesAndMarcas();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = 2023")
    List<String> listarVehiculosActuales();

    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v JOIN Siniestro s ON v.id = s.vehiculo.id WHERE s.perdidaEconomica > 10000")
    List<String> listarVehiculoConPerdidas();

    @Query("SELECT v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica) FROM Vehiculo v JOIN Siniestro s ON v.id = s.vehiculo.id WHERE s.perdidaEconomica > 10000")
    List<String> listarVehiculoConSumaDePerdida();

    //volve al lol yani

}

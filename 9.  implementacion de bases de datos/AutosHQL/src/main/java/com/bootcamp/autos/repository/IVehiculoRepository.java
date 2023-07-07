package com.bootcamp.autos.repository;

import com.bootcamp.autos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {


    @Query("SELECT v.patente FROM Vehiculo AS v ")
    List<Vehiculo> findPatente();

    @Query("SELECT v.patente, v.marca FROM Vehiculo AS v ORDER BY v.anioFabricacion")
    List<Vehiculo> findPatenteAndMarceOrderByAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo AS v WHERE v.cantRuedas>=4 AND v.anioFabricacion=CURRENT_DATE")
    List<Vehiculo> findVehiculoByAnioFabricacionAndCantRuedas();

    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo AS v JOIN Siniestro as s WHERE s.perdidaEconomica>=1000")
    List<Vehiculo> findVehiculoByPerdidasEconomicas();

    // despues cheequea esta queey jjuanma

    @Query("SELECT v.id, v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica) FROM Vehiculo AS v JOIN Siniestro as s WHERE s.perdidaEconomica>=1000 GROUP BY v.id")
    List<Vehiculo> ultimaQueryQueNOEntendi();
}

package com.bootcamp.autos.repository;

import com.bootcamp.autos.dto.PatenteModeloVehiculoDTO;
import com.bootcamp.autos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {


    @Query("SELECT v.patente FROM Vehiculo AS v ")
    List<String> findPatente();

    @Query("FROM Vehiculo AS v ORDER BY v.anioFabricacion")
    List<Vehiculo> findPatenteAndMarceOrderByAnioFabricacion();
    /*
    @Query("SELECT v.patente FROM Vehiculo AS v WHERE v.cantRuedas>=4 AND v.anioFabricacion =  current_date")
    List<Vehiculo> findVehiculoByAnioFabricacionAndCantRuedas();
    */
    @Query("FROM Vehiculo AS v JOIN Siniestro as s ON v.id = s.vehiculo.id WHERE s.perdidaEconomica>=2000")
    List<Vehiculo> findVehiculoByPerdidasEconomicas();

    // despues cheequea esta queey jjuanma

    @Query("SELECT v.id, v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica) FROM Vehiculo AS v JOIN Siniestro as s WHERE s.perdidaEconomica>=1000 GROUP BY v.id")
    List<Vehiculo> ultimaQueryQueNOEntendi();
}

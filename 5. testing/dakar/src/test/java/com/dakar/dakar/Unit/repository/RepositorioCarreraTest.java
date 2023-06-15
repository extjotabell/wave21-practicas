package com.dakar.dakar.Unit.repository;

import com.dakar.dakar.Entity.Auto;
import com.dakar.dakar.Entity.Moto;
import com.dakar.dakar.Entity.Vehiculo;
import com.dakar.dakar.repository.RepositorioCarrera;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RepositorioCarreraTest {
    RepositorioCarrera repositorio = new RepositorioCarrera();

    @Test
    public void agregarAutoTest(){
        //Arrange
        Vehiculo auto = new Auto(180D, 340D, 40D, "Patente");
        List<Vehiculo> expectedVehicles = new ArrayList<>();
        expectedVehicles.add(auto);
        //Act
        this.repositorio.agregarVehiculo(auto);
        //Assert
        assertEquals(expectedVehicles, this.repositorio.vehiculosRegistrados());
    }

    @Test
    public void agregarMotoTest(){
        //Arrange
        Vehiculo moto = new Moto(180D, 340D, 40D, "Patente");
        List<Vehiculo> expectedVehicles = new ArrayList<>();
        expectedVehicles.add(moto);
        //Act
        this.repositorio.agregarVehiculo(moto);
        //Assert
        assertEquals(expectedVehicles, this.repositorio.vehiculosRegistrados());
    }

    @Test
    public void eliminarVehiculoTest(){
        //Arrange
        Vehiculo vehiculo = new Auto(180D, 340D, 40D, "Patente");
        //Act
        this.repositorio.eliminarVehiculo(vehiculo);
        //Assert
        assertEquals(Collections.emptyList(), this.repositorio.vehiculosRegistrados());
    }

    @Test
    public void eliminarVehiculoConPatenteTest(){
        //Arrange
        String patente = "CARRRO";
        //Act
        this.repositorio.eliminarVehiculoConPatente(patente);
        //Assert
        assertEquals(Collections.emptyList(), this.repositorio.vehiculosRegistrados());
    }
}

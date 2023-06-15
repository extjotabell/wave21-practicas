package com.dakar.dakar.Unit.service;

import com.dakar.dakar.Entity.Auto;
import com.dakar.dakar.Entity.Vehiculo;
import com.dakar.dakar.repository.RepositorioCarrera;
import com.dakar.dakar.service.Carrera;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CarreraTest {
    @Mock
    RepositorioCarrera repositorioCarrera;

    @InjectMocks
    Carrera carreraService;

    @Test
    public void darDeAltaAutoTest(){
        //Arrange
        Auto auto = new Auto(180D, 340D, 40D, "Patente");
        ArrayList<Vehiculo> listVehicles = new ArrayList<>();
        listVehicles.add(auto);
        Carrera carrera = new Carrera(140D, 140D,"Carrea", 10, listVehicles, repositorioCarrera);
        //Act
        this.carreraService = carrera;
        carreraService.darDeAltaAuto(auto);
        //Assert
        verify(repositorioCarrera, times(1)).agregarVehiculo(auto);
    }

    @Test
    public void darDeAltaAutoTest(){
        //Arrange
        Auto auto = new Auto(180D, 340D, 40D, "Patente");
        ArrayList<Vehiculo> listVehicles = new ArrayList<>();
        listVehicles.add(auto);
        Carrera carrera = new Carrera(140D, 140D,"Carrea", 10, listVehicles, repositorioCarrera);
        //Act
        this.carreraService = carrera;
        carreraService.darDeAltaAuto(auto);
        //Assert
        verify(repositorioCarrera, times(1)).agregarVehiculo(auto);
    }
}

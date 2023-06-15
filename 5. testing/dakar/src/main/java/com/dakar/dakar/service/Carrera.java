package com.dakar.dakar.service;

import java.util.ArrayList;
import java.util.Comparator;
import com.dakar.dakar.Entity.*;
import com.dakar.dakar.repository.RepositorioCarrera;
public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer CantidadDeVehiculosPermitidos;
    private RepositorioCarrera repositorioCarrera;
    private Socorrista<Moto> socorristaMoto;
    private Socorrista<Auto> socorristaAuto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, ArrayList<Vehiculo> listaVehiculos, RepositorioCarrera repositorioCarrera) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        CantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.repositorioCarrera = repositorioCarrera;
    }

    public void darDeAltaAuto(Auto auto){
        if(this.CantidadDeVehiculosPermitidos > 0) repositorioCarrera.agregarVehiculo(auto);

    }
    public void darDeAltaMoto(Moto moto){
        if(this.CantidadDeVehiculosPermitidos > 0) repositorioCarrera.agregarVehiculo(moto);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        repositorioCarrera.eliminarVehiculo(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
        repositorioCarrera.eliminarVehiculoConPatente(patente);
    }

    public Vehiculo obtenerGanador(){
        return repositorioCarrera.vehiculosRegistrados().stream()
                .max(Comparator.comparingDouble(Vehiculo::calcularValor))
                .orElse(null);
    }

    public void socorrerAuto(Auto auto){
        socorristaAuto.socorrer(auto);
    }
    public void socorrerMoto(Moto moto){
        socorristaMoto.socorrer(moto);
    }
}

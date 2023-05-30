package model;

import java.util.Comparator;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private double CantidadDeVehiculosPermitidos;
    private RepositorioCarrera repositorioCarrera;

    private Socorrista<Moto> socorristaMoto;
    private Socorrista<Auto> socorristaAuto;

    public Carrera(double distancia, double premioEnDolares, String nombre, double cantidadDeVehiculosPermitidos, RepositorioCarrera repositorioCarrera) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.CantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
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

    public void socorrerCarro(Auto auto){
        socorristaAuto.socorrer(auto);
    }
    public void socorrerMoto(Moto moto){
        socorristaMoto.socorrer(moto);
    }

}

package org.example;

import org.example.Socorrista.SocorristaAuto;
import org.example.Socorrista.SocorristaMoto;
import org.example.Vehiculo.Auto;
import org.example.Vehiculo.Moto;
import org.example.Vehiculo.Vehiculo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void agregarVehiculo(Vehiculo v) {
        vehiculos.add(v);
    }
    public void darDeAltaAuto(double velocidad,double aceleracion,double anguloDeGiro,String patente) throws Exception {

        if(vehiculos.size() < cantidadDeVehiculosPermitidos){
            Vehiculo autoNuevo = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            agregarVehiculo(autoNuevo);
        }else {
            throw new Exception("No se puede agregar el auto porque no hay cupo");
        }

    }
    public void darDeAltaMoto(double velocidad,double aceleracion,double anguloDeGiro,String patente) throws Exception {
        if(vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Vehiculo motoNueva = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            agregarVehiculo(motoNueva);
        }else {
            throw new Exception("No se puede agregar la moto porque no hay cupo");
        }

    }

    public void eliminarVehiculo(Vehiculo vehiculo) throws Exception {

        if(vehiculos.remove(vehiculo)){
            System.out.println("Se eliminó el vehiculo solicitado");
        }else {
            throw new Exception("El vehiculo a eliminar no pertenece a esta carrera");
        }
    }
    public void eliminarVehiculoConPatente(String unaPatente) throws Exception {

        try {
            //esto se lo preguntaría a un repositorio no a una carrera, siento que la responsabilidad
            //queda rara acá pero bueno
            Vehiculo vehiculoEncontrado = this.encontrarVehiculoPatente(unaPatente);
            eliminarVehiculo(vehiculoEncontrado);
        } catch (NullPointerException e) {
            System.out.println("Se trata de eliminar un vehiculo que segun patente que no pertenece a esta carrera");
        }


    }

    private Vehiculo encontrarVehiculoPatente(String unaPatente) {

        return vehiculos.stream().filter(v -> v.getPatente() == unaPatente).findFirst().get();
    }

    public Vehiculo vehiculoGanador() {

        Comparator<Vehiculo> comparador = Comparator.comparing(v -> v.obtenerRanking());
        // Encuentra el máximo utilizando el comparador
        Vehiculo maximo = Collections.max(vehiculos, comparador);
        return maximo;
    }

    public void socorrerAuto(String patente){
        //es correcto castear?
        Auto autoASocorrer = (Auto) encontrarVehiculoPatente(patente);
        socorristaAuto.socorrer(autoASocorrer);

    }
    public void setSocorristaMoto(String patente){
        Moto motoASocorrer = (Moto) encontrarVehiculoPatente(patente);
        socorristaMoto.socorrer(motoASocorrer);
    }


}

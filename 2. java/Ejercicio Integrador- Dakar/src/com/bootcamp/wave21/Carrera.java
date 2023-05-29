package com.bootcamp.wave21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    List<Vehiculo> vehiculos;
    Socorrista socorristaMoto ;
    Socorrista socorristaAuto ;

    public Carrera(double distanci, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distanci;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<Vehiculo>();
        this.socorristaMoto = new SocorristaMoto();
        this.socorristaAuto = new SocorristaAuto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(this.vehiculos.size() == cantidadDeVehiculosPermitidos){
            System.out.println("El cupo se encuentra lleno");
        }else{
            this.vehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
        }

    }

    public void darDeAltaMoto(double velocidad,double aceleracion,double anguloDeGiro,String patente){
        if(this.vehiculos.size() == cantidadDeVehiculosPermitidos){
            System.out.println("El cupo se encuentra lleno");
        }else{
            this.vehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
        }

    }
    public void eliminarVehiculo(Vehiculo vehículo){

        this.vehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){

        for(Vehiculo vehiculo: this.vehiculos){
            if(unaPatente.equals(vehiculo.getPatente())){
                this.vehiculos.remove(vehiculo);
                break;
            }
        }
    }
    public Vehiculo definirGanador() {

        /*    Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100) */
        double proximoVehiculo;
        double maximo = 0;
        Vehiculo ganador = null;
        for(Vehiculo vehiculo: this.vehiculos){
        proximoVehiculo = (vehiculo.getVelocidad() * (0.5 * vehiculo.getAceleración()))/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100));
            if(proximoVehiculo > maximo){
                maximo = proximoVehiculo;
                ganador = vehiculo;
            }
        }
        return ganador;
    }

    public Vehiculo buscarVehiculoPorPatente(String patente){

        for(Vehiculo vehiculo : this.getVehiculos()){
            if(patente.equals(vehiculo.getPatente())){
                return vehiculo;
            }
        }
        return null;
    }

    public void socorrerAuto(String patente){

        Vehiculo vehiculo = buscarVehiculoPorPatente(patente);
        if(vehiculo == null){
            System.out.println("Patente no encontrada");
        }else{

            socorristaAuto.socorrer(vehiculo);
        }


    }

    public void socorrerMoto(String patente){
        Vehiculo vehiculo = buscarVehiculoPorPatente(patente);
        if(vehiculo == null){
            System.out.println("Patente no encontrada");
        }else{

            socorristaMoto.socorrer(vehiculo);
        }
    }

    public Optional<Vehiculo> definirGanadorPorLambda(){

        return this.getVehiculos().stream().max(Comparator.comparingDouble(Vehiculo::obtenerResumenCarrera));
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
}

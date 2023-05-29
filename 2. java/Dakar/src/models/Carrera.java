package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos; //Cupos
    private List<Vehiculo> listDeVehiculos;

    public Carrera() {
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listDeVehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        if (this.cantidadDeVehiculosPermitidos != 0){
            this.listDeVehiculos.add(auto);
            this.cantidadDeVehiculosPermitidos--;
        }
        else{
            System.out.println("No hay mas cupos...");
        }
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        if (this.cantidadDeVehiculosPermitidos != 0){
            this.listDeVehiculos.add(moto);
            this.cantidadDeVehiculosPermitidos--;
        }
        else{
            System.out.println("No hay mas cupos...");
        }
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        List<Vehiculo> result = this.listDeVehiculos.stream().filter(v -> v == vehículo).collect(Collectors.toList());
        if(result.size() != 0){
            this.listDeVehiculos = this.listDeVehiculos.stream()
                    .filter(v -> !v.equals(vehículo))
                    .collect(Collectors.toList());
            this.cantidadDeVehiculosPermitidos++;
        }
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        List<Vehiculo> result = this.listDeVehiculos.stream().filter(v -> v.getPatente().equals(unaPatente)).collect(Collectors.toList());
        if(result.size() != 0){
            this.listDeVehiculos = this.listDeVehiculos.stream()
                    .filter(v -> !(v.getPatente().equals(unaPatente)))
                    .collect(Collectors.toList());
            this.cantidadDeVehiculosPermitidos++;
        }
    }

    public Optional<Vehiculo> obtenerGanador(){
        Vehiculo ganador = null;
        double resultGanador = 0;

        for (Vehiculo v: this.listDeVehiculos){
            //Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
            double calculo = v.getVelocidad() * 0.5 * v.getAceleración()/(v.getAnguloDeGiro()*(v.getPeso() - v.getRuedas() - 100));
            if (calculo >= resultGanador){
                ganador = v;
            }
        }
        if(ganador == null){
            return Optional.empty();
        }

        return Optional.of(ganador);
    }

    public Optional<Vehiculo> obtenerVehiculo(String patente){
        List<Vehiculo> result = this.listDeVehiculos.stream().filter(v -> v.getPatente().equals(patente)).collect(Collectors.toList());
        if (result.size() != 0){
            return Optional.of(result.get(0));
        }
        return Optional.empty();
    }
    public void socorrerAuto(String patente){
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        Optional<Vehiculo> v = this.obtenerVehiculo(patente);
        if(!v.isEmpty()){
            socorristaAuto.socorrer((Auto) v.get());
        }
    }
    public void socorrerMoto(String patente){
        SocorristaMoto socorristaMoto = new SocorristaMoto();
        Optional<Vehiculo> v = this.obtenerVehiculo(patente);
        if(!v.isEmpty()){
            socorristaMoto.socorrer((Moto) v.get());
        }
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

    public List<Vehiculo> getListDeVehiculos() {
        return listDeVehiculos;
    }

    public void setListDeVehiculos(List<Vehiculo> listDeVehiculos) {
        this.listDeVehiculos = listDeVehiculos;
    }
}

package clases;

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

    public double getCantidadDeVehiculosPermitidos() {
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
    public void darDeAltaAuto(double velocidad, double aceleracion,double anguloDeGiro, String patente){
        if (vehiculos.size() < cantidadDeVehiculosPermitidos){
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            cantidadDeVehiculosPermitidos -= 1;
        }
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (cantidadDeVehiculosPermitidos > 0){
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            cantidadDeVehiculosPermitidos -= 1;
        }
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
        cantidadDeVehiculosPermitidos += 1;
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
        cantidadDeVehiculosPermitidos += 1;
    }

    public void socorrerAuto(String patente){
        Auto vehiculoSocorrer = (Auto) vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().orElse(null);
        if (vehiculoSocorrer != null){
            socorristaAuto.socorrer(vehiculoSocorrer);
        } else {
            System.out.println("Vehiculo no encontrado");
        }
    }

    public void socorrerMoto(String patente){
        Moto vehiculoSocorrer = (Moto) vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().orElse(null);
        if (vehiculoSocorrer != null){
            socorristaMoto.socorrer(vehiculoSocorrer);
        } else {
            System.out.println("Vehiculo no encontrado");
        }
    }

    public Vehiculo defineGanador(){
        return vehiculos.stream().max(Comparator.comparingDouble(Vehiculo::calcularResultado)).orElse(null);
    }

}

package model;

import java.util.List;
import java.util.Optional;

public class Carrera {
    private float distancia;
    private double premioEnDolares;
    private  String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(float distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
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

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaAuto(int velocidad, float aceleracion, int anguloDeGiro, String patente){
        if(listaDeVehiculos.size()<this.cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
        }
    }
    public void darDeAltaMoto(int velocidad, float aceleracion, int anguloDeGiro, String patente){
        if(listaDeVehiculos.size()<this.cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculoBorrado){
        for (Vehiculo vehiculo: listaDeVehiculos) {
            if(vehiculo.equals(vehiculoBorrado)){
                listaDeVehiculos.remove(vehiculoBorrado);
            }
        }
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        for (Vehiculo vehiculo: listaDeVehiculos) {
            if(vehiculo.getPatente().equals(unaPatente)){
                listaDeVehiculos.remove(vehiculo);
            }
        }
    }

    public Vehiculo ganadorDeLaCarrera(){
        Vehiculo ganador = listaDeVehiculos.get(0);
        for (Vehiculo vehiculo: listaDeVehiculos) {
            if(calcularPos(ganador)< calcularPos(vehiculo)){
                ganador = vehiculo;
            }
        }
        return  ganador;
    }
    private Double calcularPos(Vehiculo vehiculo){
        return (vehiculo.getVelocidad() * (vehiculo.getAceleracion()/2) / (vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas() * 100)));

    }
    private Vehiculo obtenerVehiculo(String patente){
        for (Vehiculo vehiculo: this.listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                return vehiculo;
            }
        }
        return null;
    }
    public void socorrerAuto(String patente){
        Vehiculo vehiculoASocorrer = obtenerVehiculo(patente);
        if(vehiculoASocorrer != null)
            socorristaAuto.socorrer((Auto) vehiculoASocorrer);
    }
    public void socorrerMoto(String patente){
        Vehiculo vehiculoASocorrer = obtenerVehiculo(patente);
        if(vehiculoASocorrer != null)
            socorristaMoto.socorrer((Moto) vehiculoASocorrer);
    }


}

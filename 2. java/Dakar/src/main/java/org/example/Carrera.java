package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private int distancia;
    private double premioEnDolares;
    private String nombre;

    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;

    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(int distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
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

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void darDeAltaAuto(int velocidad,int aceleracion,int anguloDeGiro, String patente){
       if (listaVehiculos.size()<cantidadDeVehiculosPermitidos){
            listaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro,patente));
            System.out.println("Vehiculo agregado con exito");
       } else System.out.println("Cupos agotados");
    };
    public void darDeAltaMoto(int velocidad,int aceleracion, int anguloDeGiro, String patente){
        if (listaVehiculos.size()<cantidadDeVehiculosPermitidos){
            listaVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro,patente));
            System.out.println("Vehiculo agregado con exito");
        } else System.out.println("Cupos agotados");
    };

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaVehiculos.remove(vehiculo);
        System.out.println("Vehiculo eliminado con exito");
    };
    public void eliminarVehiculoConPatente(String unaPatente){
        Vehiculo vehiculoEliminado = buscarVehiculoPorPatente(unaPatente);
        listaVehiculos.remove(vehiculoEliminado);
        if (vehiculoEliminado != null) {
            System.out.println("Vehiculo eliminado con exito");
        } else {
            System.out.println("No se encontró la patente ingresada");
        }
    };

    public Vehiculo getGanador(){
        Vehiculo ganador = null;
        int puntajeGanador =0;
        for (int i= 0; i<listaVehiculos.size(); i++){
            Vehiculo aux = listaVehiculos.get(i);
            int puntaje = (aux.getVelocidad()*(aux.getAceleración()/2)/(aux.getAnguloDeGiro()*(aux.getPeso()-aux.getRuedas() * 100)));
            if (puntaje > puntajeGanador){
                puntajeGanador = puntaje;
                ganador = aux;
            }
        }
        return ganador;
    }

    public Vehiculo buscarVehiculoPorPatente(String patente){
        Vehiculo vehiculoEncontrado = listaVehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
        if (vehiculoEncontrado !=null) {
            return vehiculoEncontrado;
        } else return null;
    }

    public void socorrerAuto(String patente){
        socorristaAuto.socorrer((Auto) buscarVehiculoPorPatente(patente));
    };
    public void socorrerMoto(String patente){
        socorristaMoto.socorrer((Moto) buscarVehiculoPorPatente(patente));
    }

}

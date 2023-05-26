package Dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Integer distancia;
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    public Carrera(Integer distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<Vehiculo>();
    }

    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, Integer patente) {
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(auto);
            System.out.println("Auto añadido exitosamente!");
        }else{
            System.out.println("La carrera no tiene mas cupos disponibles!");
        }

    }

    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, Integer patente) {
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(moto);
            System.out.println("Moto añadida exitosamente!");
        }else{
            System.out.println("La carrera no tiene mas cupos disponibles!");
        }
    }

    public void eliminarVehiculo(Vehiculo v){
        if (listaDeVehiculos.contains(v)) {
            listaDeVehiculos.remove(v);
            System.out.println("El vehiculo fue eliminado exitosamente!");
        }else
            System.out.println("Ese vehiculo no esta en el sistema!");

    }

    public void eliminarVehiculoConPatente(String patente){
        for(Vehiculo v : listaDeVehiculos){
            if(v.getPatente().toString().equals(patente)){
                listaDeVehiculos.remove(v);
                System.out.println("El vehiculo fue eliminado exitosamente!");
                break;
            }else{
                System.out.println("Ese vehiculo no esta en el sistema!");            }
        }
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Integer getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Integer premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }
}

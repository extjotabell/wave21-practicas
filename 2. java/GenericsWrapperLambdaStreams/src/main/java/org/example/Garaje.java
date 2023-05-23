package org.example;

//Ejercicio 1
import java.util.List;

public class Garaje{
    private int id;
    private int identificador;
    List<Vehiculo> listVehiculo;

    public Garaje(int id, int identificador, List<Vehiculo> listVehiculo) {
        this.id = id;
        this.identificador = identificador;
        this.listVehiculo = listVehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public List<Vehiculo> getListVehiculo() {
        return listVehiculo;
    }

    public void setListVehiculo(List<Vehiculo> listVehiculo) {
        this.listVehiculo = listVehiculo;
    }
}

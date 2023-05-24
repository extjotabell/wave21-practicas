package com.bootcamp.wave21;
import java.util.ArrayList;
import java.util.List;

public class Garage {
    /*id y lista de vehiculos*/
    private int id;
    private List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    public Garage() {
    }

    public Garage(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}

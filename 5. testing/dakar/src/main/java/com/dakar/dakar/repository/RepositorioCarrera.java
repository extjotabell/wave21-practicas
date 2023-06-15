package com.dakar.dakar.repository;



import com.dakar.dakar.Entity.Vehiculo;

import java.util.ArrayList;

public class RepositorioCarrera {
    ArrayList<Vehiculo> listaVehiculos;

    public RepositorioCarrera() {
        this.listaVehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        listaVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public ArrayList<Vehiculo> vehiculosRegistrados(){
        return listaVehiculos;
    }
}

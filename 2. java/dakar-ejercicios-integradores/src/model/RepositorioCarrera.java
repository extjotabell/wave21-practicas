package model;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCarrera {

    List<Vehiculo> listaVehiculos;

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

    public List<Vehiculo> vehiculosRegistrados(){
        return listaVehiculos;
    }

}

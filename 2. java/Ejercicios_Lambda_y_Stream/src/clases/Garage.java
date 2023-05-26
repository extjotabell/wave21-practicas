package clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garage {
    private int id;
    private ArrayList<Vehiculo> vehiculos;

    public Garage(int id, ArrayList<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Vehiculo> listOrdenada(){
        List<Vehiculo> ordenada = getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        return (ArrayList<Vehiculo>) ordenada;
    }

    public ArrayList<Vehiculo> listOrdenadaPorMarca(){
        List<Vehiculo> ordenada = getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        return (ArrayList<Vehiculo>) ordenada;
    }

    public ArrayList<Vehiculo> listMenoresCostos(){
        List<Vehiculo> menores = getVehiculos().stream()
                .filter( (x) -> x.getCosto() < 1000)
                .collect(Collectors.toList());
        return (ArrayList<Vehiculo>) menores;
    }

    public ArrayList<Vehiculo> listMayoresCostos(){
        List<Vehiculo> mayores = getVehiculos().stream()
                .filter( (x) -> x.getCosto() >= 1000)
                .collect(Collectors.toList());
        return (ArrayList<Vehiculo>) mayores;
    }

    public double promedioCostos(){
        double promedio = getVehiculos().stream()
                .mapToDouble(v -> v.getCosto())
                .average()
                .orElse(0D);
        return promedio;
    }
}

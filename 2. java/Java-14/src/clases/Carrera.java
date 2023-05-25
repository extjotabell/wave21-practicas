package clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculos.size() >= this.cantidadDeVehiculosPermitidos) return;

        vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculos.size() >= this.cantidadDeVehiculosPermitidos) return;

        vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        vehiculos.removeIf(vehiculo -> vehiculo.patente.equals(patente));
    }

    public void definirGanador(){
        Optional<Vehiculo> ganador = vehiculos.stream().max(Comparator.comparing(vehiculo -> vehiculo.velocidad * 0.5 * vehiculo.aceleracion / (vehiculo.anguloDeGiro * (vehiculo.peso - vehiculo.ruedas * 100))));

        if(ganador.isPresent()) System.out.println("Ganador: " + ganador.get().patente);
        else System.out.println("No hay ganador");
    }

    public void socorrerAuto(String patente){
        Vehiculo vehiculo = this.getVehiculo(patente);
        if(vehiculo instanceof Auto) socorristaAuto.socorrer((Auto) vehiculo);
    }

    public void socorrerMoto(String patente){
        Vehiculo vehiculo = this.getVehiculo(patente);
        if (vehiculo instanceof Moto) socorristaMoto.socorrer((Moto) vehiculo);
    }

    private Vehiculo getVehiculo(String patente){
        return vehiculos
                .stream()
                .filter(vehiculo -> vehiculo.patente.equals(patente))
                .findFirst()
                .orElse(null);
    }
}

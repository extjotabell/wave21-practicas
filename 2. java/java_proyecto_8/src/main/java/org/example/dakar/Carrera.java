package org.example.dakar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = listaVehiculos;
        socorristaAuto = new SocorristaAuto();
        socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Auto auto) {
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaVehiculos.add(auto);
            System.out.println("El auto fue añadido con exito");
        } else {
            System.out.println("No hay mas cupos en esta carrera");
        }
    }

    public void darDeAltaMoto(Moto moto) {
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaVehiculos.add(moto);
            System.out.println("La moto fue añadida con exito");
        } else {
            System.out.println("No hay mas cupos en esta carrera");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (listaVehiculos.contains(vehiculo)) {
            listaVehiculos.remove(vehiculo);
            System.out.println("El vehículo fue eliminado con exito");
        } else {
            System.out.println("No se encontró el vehículo a eliminar");
        }
    }

    public void eliminarVehiculoConPatente(String patente) {
        if (listaVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente))) {
            System.out.println("El vehículo con patente " + patente + " fue eliminado correctamente");
        } else {
            System.out.println("El vehículo con patente " + patente + " no fue encontrado");
        }
        System.out.println(listaVehiculos);
    }

    public Vehiculo calcularGanador() {
        Vehiculo vehiculoGanador = null;
        Double valorMinimo = Double.valueOf(Integer.MIN_VALUE);

        for (Vehiculo vehiculo : listaVehiculos) {
            Double calculo = vehiculo.getVelocidad() * (vehiculo.getAceleración() / 2) / (vehiculo.getÁnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            System.out.println(vehiculo + ": " + calculo);

            if (calculo > valorMinimo) {
                valorMinimo = calculo;
                vehiculoGanador = vehiculo;
            }
        }

        return vehiculoGanador;
    }

    public void socorrerAuto(String patente) {
        boolean flag = true;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo instanceof Auto && vehiculo.getPatente().equals(patente)) {
                socorristaAuto.socorrer((Auto) vehiculo);
                flag = false;
            }
        }
        if (flag) System.out.println("No se encontró el auto para socorrer");

    }

    public void socorrerMoto(String patente) {
        boolean flag = true;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo instanceof Moto && vehiculo.getPatente().equals(patente)) {
                socorristaMoto.socorrer((Moto) vehiculo);
                flag = false;
            }
        }
        if (flag) System.out.println("No se encontró el auto para socorrer");

    }
}

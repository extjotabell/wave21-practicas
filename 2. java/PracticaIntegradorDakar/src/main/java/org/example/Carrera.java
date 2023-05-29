package org.example;

import java.text.DecimalFormat;
import java.util.*;

public class Carrera {
    private Double distancia;
    private Double premioDolares;
    private String nombre;
    private Integer cantidadVehiculosPer; //Cantidad de vehiculos permitidos
    private Set<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioDolares, String nombre, Integer cantidadVehiculosPer) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPer = cantidadVehiculosPer;
        this.listaVehiculos = new HashSet<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        //Validar que haya cupo en la carrera
        if (!cupoDisponible()) {
            System.out.println("No hay cupo disponible para dar de alta un auto ");
            return;
        }

        //Crear un nuevo auto
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);

        //Validar que no haya sido agregado previamente
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPatente().equals(auto.getPatente())) {
                System.out.println("El Auto ya estaba inscripto");
                return;
            }
        }

        listaVehiculos.add(auto);
        System.out.println("Auto Agregado Automagicamente");
    }

    private Boolean cupoDisponible() {
        return cantidadVehiculosPer > listaVehiculos.size();
    }

    public void darAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {

        //Validar que haya cupo en la carrera
        if (!cupoDisponible()) {
            System.out.println("No hay cupo disponible para dar de alta una moto");
            return;
        }
        //Crear una nueva moto
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);

        //Validar que no haya sido agregado previamente
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPatente().equals(moto.getPatente())) {
                System.out.println("La moto ya estaba inscripta");
                return;
            }
        }

        listaVehiculos.add(moto);
        System.out.println("Moto Agregada Automagicamente");
    }

    public void eliminarVehiculo(String patente) {

        Vehiculo vehiculosAEliminar = null;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                vehiculosAEliminar = vehiculo;
            }
        }

        if (vehiculosAEliminar != null) {
            eliminarVehiculo(vehiculosAEliminar);
        } else {
            System.out.println("El vehículo solicitado para eliminar no se encuentra inscripto.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (listaVehiculos.remove(vehiculo)) {
            System.out.println("Se eliminó correctamente al vehículo: " + vehiculo);
        } else {
            System.out.println("El vehículo: " + vehiculo + " no se encuentra inscripto.");
        }
    }

    public void socorrerAuto(String patente) {
        Auto autoASocorrer = null;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPatente().equals(patente) && vehiculo instanceof Auto) {
                autoASocorrer = (Auto) vehiculo;
            }
        }

        if (autoASocorrer != null) {
            socorristaAuto.socorrer(autoASocorrer);
        } else {
            System.out.println("No existe auto con la patente especificada para ser socorrido.");
        }
    }

    public void socorrerMoto(String patente) {
        Moto motoASocorrer = null;

        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPatente().equals(patente) && vehiculo instanceof Moto) {
                motoASocorrer = (Moto) vehiculo;
            }
        }

        if (motoASocorrer != null) {
            socorristaMoto.socorrer(motoASocorrer);
        } else {
            System.out.println("No existe moto con la patente especificada para ser socorrido.");
        }
    }

    private Optional<Vehiculo> calcularGanador() {

        listaVehiculos.stream().forEach(vehiculo -> {
            vehiculo.setCalcularGanador((vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2))
                    / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100)));
        });

        Double max = listaVehiculos.stream().map(Vehiculo::getCalcularGanador).max(Comparator.naturalOrder()).get();

        return listaVehiculos.stream().filter(vehiculo -> vehiculo.getCalcularGanador().equals(max)).findFirst();

    }

    public void imprimirGanador() {

        Optional<Vehiculo> vehiculoGan = calcularGanador();
        if (vehiculoGan.isPresent()) {
            DecimalFormat df = new DecimalFormat("#.000");
            System.out.println("El ganador es: " + vehiculoGan.get().getPatente() + " con un valor de: " + df.format(vehiculoGan.get().getCalcularGanador()));
        } else {
            System.out.println("No se encontro ningun ganador");
        }
    }
}

package Clases;

import Interfaces.SocorristaAuto;
import Interfaces.SocorristaMoto;

import java.util.List;

public class Carrera  {
    private Double distancia;
    private Integer premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){

            if(this.cantidadDeVehiculosPermitidos > listaDeVehiculos.stream().count() ) {
                Vehiculo nuevoAuto = new Auto(velocidad,aceleracion,anguloDeGiro,patente);

                this.listaDeVehiculos.add(nuevoAuto);

            }
        }
    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){

        if(this.cantidadDeVehiculosPermitidos > listaDeVehiculos.stream().count() ) {
            Vehiculo nuevaMoto = new Moto(velocidad,aceleracion,anguloDeGiro,patente);

            this.listaDeVehiculos.add(nuevaMoto);

        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        this.listaDeVehiculos.removeIf( v -> v.equals(vehiculo));
    }
    public void eliminarVechiculiPorPatente(String patente){
        this.listaDeVehiculos.removeIf(v -> v.getPatente().equals((patente)));
    }
    public double calcularResultado(Vehiculo v){
        double resultado  =
                v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));
        return resultado;
    }
    public Vehiculo determinarGanador(){

        Vehiculo ganador = this.listaDeVehiculos.get(0);
        double resultadoGanador = calcularResultado(ganador);

        for(int i = 1 ; i < this.listaDeVehiculos.size() ; i++ ){
            double resultadoVehiculo = calcularResultado(this.listaDeVehiculos.get(i));
            if(resultadoVehiculo > resultadoGanador ){
                ganador = this.listaDeVehiculos.get(i);
                resultadoGanador = resultadoVehiculo;
            }
        }
        return ganador;
    }
    public void socorrerAuto(String patente){
        System.out.println("Socorriendo auto: "+ patente);
    }
    public void socorrerMoto(String patente){
        System.out.println("Socorriendo Moto: "+ patente);
    }


    public Carrera(Double distancia, Integer premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void imprimirVehiculosDeLaCarrera(){
        this.listaDeVehiculos.stream()
                .forEach();
    }
}








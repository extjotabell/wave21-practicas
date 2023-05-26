package dakar;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private Map<String,Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;

    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new HashMap<>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public Map<String,Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Map<String,Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculos.size() < cantidadDeVehiculosPermitidos){
            vehiculos.put(patente, new Auto(velocidad, aceleracion,anguloDeGiro, patente));
            System.out.println("Se ha ingresado el auto " + patente);
        }else{
            System.out.println("Número de vehículos por carrera excedido, no se ha podido ingresar el auto " + patente);
        }
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro,String patente){
        if(vehiculos.size() < cantidadDeVehiculosPermitidos){
            vehiculos.put(patente, new Moto(velocidad, aceleracion,anguloDeGiro, patente));
            System.out.println("Se ha ingresado la moto " + patente);
        }else{
            System.out.println("Número de vehículos por carrera excedido, no se ha podido ingresar la moto " + patente);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        eliminarVehiculoConPatente(vehiculo.getPatente());
    }
    public void eliminarVehiculoConPatente(String patente){
        System.out.print("\nVehículo con patente: " + patente);
        if(vehiculos.containsKey(patente)){
            vehiculos.remove(patente);
            System.out.println(" se ha eliminado.");
        }else {
            System.out.print(" no estaba registrado en la carrera.");
        }
    }

    public void getWinner(){
        AtomicReference<String> patenteGanadora = new AtomicReference<>("");
        AtomicReference<Double> counter = new AtomicReference<>(0D);
        vehiculos.forEach((patente,vehiculo) ->{
            double totalVehiculo = (vehiculo.getVelocidad() * (0.5 * vehiculo.getAceleracion())) /
                    (vehiculo.getAnguloDeGiro() * ((vehiculo.getPeso() - Double.parseDouble(vehiculo.getRuedas() + "")) * 100D));
            if(totalVehiculo > counter.get()){
                counter.set(totalVehiculo);
                patenteGanadora.set(patente);
            }
        });

        Vehiculo ganador = vehiculos.get(patenteGanadora.get());
        System.out.println("\n\n-----------------------------------------\n" +
                "GANADOR DE LA CARRERA:\n" +
                "-----------------------------------------\n" +
                "Patente: " + ganador.getPatente() + "\n" +
                "Velocidad: " + ganador.getVelocidad() + "\n" +
                "Aceleración: " + ganador.getAceleracion() + "\n" +
                "Angulo de giro: " + ganador.getAnguloDeGiro() + "\n" +
                "Peso: " + ganador.getPeso() + "\n" +
                "Ruedas: " + ganador.getRuedas() + "\n" +
                "----------------------");
    }

    public void socorrerAuto(String patente){
        System.out.print("Socorrista: "+ socorristaAuto.getNombre() + " está ");
        socorristaAuto.socorrer((Auto) vehiculos.get(patente));
    }
    public void socorrerMoto(String patente){
        System.out.print("Socorrista: "+ socorristaMoto.getNombre() + " está ");
        socorristaMoto.socorrer((Moto) vehiculos.get(patente));
    }

}

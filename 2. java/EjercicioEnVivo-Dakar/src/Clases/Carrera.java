package Clases;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    //region Variables Privadas
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;
    //endregion


    //region Getters / Setters
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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
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
//endregion


    //region Constructores
    public Carrera() {
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }
    //endregion

    public Vehiculo calcularGanador(){
        double valorFormulaMaxima = 0;
        Vehiculo vehiculoGanador = null;

        for (Vehiculo v: vehiculos) {
            double resultadoFormula = v.calcular();
            if (resultadoFormula > valorFormulaMaxima){
                valorFormulaMaxima = resultadoFormula;
                vehiculoGanador = v;
            }
        }

        return vehiculoGanador;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        Auto nuevoAuto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        darDeAlta(nuevoAuto);
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        Moto nuevaMoto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        darDeAlta(nuevaMoto);
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        // Para utilizar la validacion realizada en la eliminacion con Patente ya que puede que el objeto Vehiculo
        // no exista en la coleccion.
        eliminarVehiculoConPatente(vehiculo.getPatente());
        //eliminar(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        Vehiculo vehiculo = vehiculos.stream()
                .filter(v -> v.getPatente().equals(unaPatente))
                .findFirst()
                .orElse(null);

        eliminar(vehiculo);
    }

    public void socorrerAuto(String patente){
        Vehiculo v = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst()
                .orElse(null);

        if (v != null) {
            if (v instanceof Auto) {
                socorristaAuto.socorrer((Auto) v);
            }
            else{
                System.out.println("No hay un Auto con esa patente");
            }
        }
        else{
            System.out.println("No hay vehiculo con esa patente");
        }
    }

    public void socorrerMoto(String patente){
        Vehiculo v = (Vehiculo) vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst()
                .orElse(null);

        if (v != null) {
            if (v instanceof Moto) {
                socorristaMoto.socorrer((Moto) v);
            }
            else{
                System.out.println("No hay un Moto con esa patente");
            }
        }
        else{
            System.out.println("No hay vehiculo con esa patente");
        }

    }
    private void eliminar(Vehiculo vehiculo){
        if (vehiculo != null){
            vehiculos.remove(vehiculo);
        }
        else {
            System.out.println("El vehiculo que desea eliminar no existe en la carrera");
        }
    }

    private void darDeAlta(Vehiculo vehiculo){
        if (vehiculos.size() < cantidadDeVehiculosPermitidos){
            vehiculos.add(vehiculo);
        }
        else {
            System.out.println("No se puede agregar a la carrera debido a que no hay cupos");
        }
    }

}

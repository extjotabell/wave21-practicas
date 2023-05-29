import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculoList;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculoList = new ArrayList<Vehiculo>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (cantidadDeVehiculosPermitidos > 0) {
            vehiculoList.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            cantidadDeVehiculosPermitidos--;
        }
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (cantidadDeVehiculosPermitidos > 0) {
            vehiculoList.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            cantidadDeVehiculosPermitidos--;
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(vehiculoList.remove(vehiculo))
            cantidadDeVehiculosPermitidos ++;
    }

    public void eliminarVehiculoConPatente(String patente){
        if(vehiculoList.remove(vehiculoList.stream().anyMatch(vehiculo -> vehiculo.getPatente() == patente)))
            cantidadDeVehiculosPermitidos ++;
    }

    public Vehiculo ganador(){
        Comparator<Vehiculo> c = Comparator.comparing(vehiculo -> vehiculo.getVelocidad()*0.5*vehiculo.getAceleracion()/(vehiculo.getAnguloDeGiro()*(ganador().getPeso()) - vehiculo.getRuedas()*100));
        return vehiculoList.stream().max(c).orElse(null);
    }
}

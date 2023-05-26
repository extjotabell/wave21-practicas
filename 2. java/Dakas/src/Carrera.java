import java.util.ArrayList;
import java.util.Comparator;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer CantidadDeVehiculosPermitidos;
    private RepositorioCarrera repositorioCarrera;
    private Socorrista<Moto> socorristaMoto;
    private Socorrista<Auto> socorristaAuto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, ArrayList<Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        CantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.repositorioCarrera = new RepositorioCarrera();
    }

    public void darDeAltaAuto(Auto auto){
        if(this.CantidadDeVehiculosPermitidos > 0) repositorioCarrera.agregarVehiculo(auto);

    }
    public void darDeAltaMoto(Moto moto){
        if(this.CantidadDeVehiculosPermitidos > 0) repositorioCarrera.agregarVehiculo(moto);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        repositorioCarrera.eliminarVehiculo(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
        repositorioCarrera.eliminarVehiculoConPatente(patente);
    }

    public Vehiculo obtenerGanador(){
        return repositorioCarrera.vehiculosRegistrados().stream()
                .max(Comparator.comparingDouble(Vehiculo::calcularValor))
                .orElse(null);
    }

    public void socorrerAuto(Auto auto){
        socorristaAuto.socorrer(auto);
    }
    public void socorrerMoto(Moto moto){
        socorristaMoto.socorrer(moto);
    }
}

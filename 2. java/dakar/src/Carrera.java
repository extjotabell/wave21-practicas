import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    SocorristaAuto socorristaAuto;

    SocorristaMoto socorristaMoto;

    public Carrera(){
        listaDeVehiculos = new ArrayList<Vehiculo>();
        socorristaMoto = new SocorristaMoto();
        socorristaAuto = new SocorristaAuto();
    }

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
        socorristaMoto = new SocorristaMoto();
        socorristaAuto = new SocorristaAuto();
    }

    public void darDeAltaAuto(Auto unAuto){
        if(this.cantidadDeVehiculosPermitidos > 0) listaDeVehiculos.add(unAuto);
    }

    public void darDeAltaMoto(Moto unaMoto){
        if(this.cantidadDeVehiculosPermitidos > 0) listaDeVehiculos.add(unaMoto);
    }

    public boolean eliminarVehiculo(Vehiculo vehiculo){
        this.listaDeVehiculos.remove(vehiculo);
        return false;
    }

    public void eliminarVehiculoConPatente(String patente){
        this.listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public void socorrerMoto(Moto unaMoto){
        socorristaMoto.socorrer(unaMoto);
    }

    public void socorrerAuto(Auto unAuto){
        socorristaAuto.socorrer(unAuto);
    }

    public Vehiculo obtenerGanador(){
        return this.listaDeVehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::calcularValor))
                .orElse(null);
    }

    public void imprimirVehiculos(){
        System.out.println("Vehículos en carrera:");
        this.listaDeVehiculos.forEach(vehiculo -> System.out.println(vehiculo.getClass()+" -> "+vehiculo.getPatente()));
        System.out.println();
    }

}

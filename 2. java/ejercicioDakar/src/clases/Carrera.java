package clases;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public void darDeAltaAuto(Double velocidad,Double aceleracion,Double AnguloDeGiro,String patente){
        if(this.cantidadVehiculosPermitidos<this.vehiculos.size())
            this.vehiculos.add(new Auto(velocidad,aceleracion,AnguloDeGiro,patente,1000d,4));
    }

    public void darDeAltaMoto(Double velocidad,Double aceleracion,Double AnguloDeGiro,String patente){
        if(this.cantidadVehiculosPermitidos<this.vehiculos.size())
            this.vehiculos.add(new Moto(velocidad,aceleracion,AnguloDeGiro,patente,300d,2));
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        this.vehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        this.vehiculos.removeIf(vehiculo -> vehiculo.patente.equals(unaPatente));
    }

    public void determinarGanador(){
        Vehiculo ganador = this.vehiculos.stream().max(Comparator.comparing(vehiculo -> vehiculo.velocidad * (1 / 2 * vehiculo.aceleracion) / (vehiculo.anguloDeGiro * (vehiculo.peso - vehiculo.ruedas * 100)))).orElseThrow(NullPointerException::new);
        System.out.println("El ganador es:\n"+ganador.toString());
    }

    public void socorrerAuto(String patente){
        this.socorristaAuto.socorrer((Auto) this.vehiculos.stream().filter(vehiculo -> vehiculo.patente.equals(patente)).findFirst().get());
    }

    public void socorrerMoto(String patente){
        this.socorristaMoto.socorrer((Moto) this.vehiculos.stream().filter(vehiculo -> vehiculo.patente.equals(patente)).findFirst().get());
    }
}

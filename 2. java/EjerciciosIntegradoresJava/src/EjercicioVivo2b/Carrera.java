package EjercicioVivo2b;

import java.util.List;

public class Carrera {
    int distancia;
    double premioEnDolares;
    String nombre;

    SocorristaMoto socorristaMoto;
    SocorristaAuto socorristaAuto;

    int cantidadDeVehiculosPermitidos;
    List<Vehiculo> listaVehiculos;


    public void darDeAltaAuto(int velocidad, int aceleracion, double anguloDeGiro, String patente){
        if(listaVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(int velocidad,int aceleracion, double anguloDeGiro, String patente){
        if(listaVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Vehiculo moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(!vehiculo.equals(null)){
            listaVehiculos.remove(vehiculo);
        }

    }
    public void eliminarVehiculoConPatente(String unaPatente){
        Vehiculo vehiculo = buscarVehiculo(unaPatente);
        if(!vehiculo.equals(null)){
            listaVehiculos.remove(vehiculo);
        }
    }

    public Vehiculo buscarVehiculo(String patente){
        for (Vehiculo vehiculo: listaVehiculos) {
            if(vehiculo.patente.equals(patente)){
                return vehiculo;
            }
        }
        return null;
    }

    public Vehiculo ganadorCarrera(){
        double valorMaximo = 0;
        Vehiculo vehiculo = new Vehiculo();
        for(Vehiculo vehi : listaVehiculos){
            double calculo = ((vehi.velocidad *(vehi.aceleracion /2)) /(vehi.anguloDeGiro*((vehi.peso-vehi.ruedas) * 100)));
            if (calculo > valorMaximo){
                valorMaximo = calculo;
                vehiculo = vehi;
            }
        }
        return vehiculo;
    }

    public void socorrerAuto(String patente){
        Vehiculo vehi = buscarVehiculo(patente);
        Auto auto = (Auto) vehi;
        socorristaAuto.socorrer(auto);
    }
    public void socorrerMoto(String patente){
        Vehiculo vehi = buscarVehiculo(patente);
        Moto moto = (Moto) vehi;
        socorristaMoto.socorrer(moto);
    }
}

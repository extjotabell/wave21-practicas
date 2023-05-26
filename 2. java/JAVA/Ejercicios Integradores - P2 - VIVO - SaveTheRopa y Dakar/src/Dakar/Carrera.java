package Dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Integer distancia;
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Integer distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<Vehiculo>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, Integer patente) {
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(auto);
            System.out.println("Auto añadido exitosamente!");
        }else{
            System.out.println("La carrera no tiene mas cupos disponibles!");
        }

    }

    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, Integer patente) {
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(moto);
            System.out.println("Moto añadida exitosamente!");
        }else{
            System.out.println("La carrera no tiene mas cupos disponibles!");
        }
    }

    public void eliminarVehiculo(Vehiculo v){
        if (listaDeVehiculos.contains(v)) {
            listaDeVehiculos.remove(v);
            System.out.println("El vehiculo fue eliminado exitosamente!");
        }else
            System.out.println("Ese vehiculo no esta en el sistema!");

    }

    public void eliminarVehiculoConPatente(String patente){
        for(Vehiculo v : listaDeVehiculos){
            if(v.getPatente().toString().equals(patente)){
                listaDeVehiculos.remove(v);
                System.out.println("El vehiculo fue eliminado exitosamente!");
                break;
            }else{
                System.out.println("Ese vehiculo no esta en el sistema!");            }
        }
    }

    public Double formulaGanadora(Vehiculo v){
        return (v.getVelocidad() * (v.getAceleracion() / 2) ) / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));
    }
    public void ganador(){
        Double max = 0.0;
        Integer patenteDelGanador = 0;
        for (Vehiculo v : listaDeVehiculos){
            Double valorActual = formulaGanadora(v);
            if(valorActual > max){
                max = valorActual;
                patenteDelGanador = v.getPatente();
            }
        }
        System.out.println("La patente del vehiculo gabador es " + patenteDelGanador + "! Con un resultado de " + max);
    }

    public void socorrerAuto(String patente){
        Auto autoASocorrer = null;
        for(Vehiculo v : listaDeVehiculos){
            if(v.getPatente().toString().equals(patente) && v instanceof Auto){
                autoASocorrer = (Auto) v;       //Al ser v del tipo Vehiculo, lo casteo a Auto
            }
        }

        if(autoASocorrer != null){
            socorristaAuto.socorrer(autoASocorrer);
        }else {
            System.out.println("No existe un Auto con esa patente!");
        }
    }

    public void socorrerMoto(String patente){
        Moto motoASocorrer = null;
        for(Vehiculo v : listaDeVehiculos){
            if(v.getPatente().toString().equals(patente) && v instanceof Moto){
                motoASocorrer = (Moto) v;       //Al ser v del tipo Vehiculo, lo casteo a Auto
            }
        }

        if(motoASocorrer != null){
            socorristaMoto.socorrer(motoASocorrer);
        }else {
            System.out.println("No existe una Moto con esa patente!");
        }
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Integer getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Integer premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }
}

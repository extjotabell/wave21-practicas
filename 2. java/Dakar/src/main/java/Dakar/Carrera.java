package Dakar;

import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Carrera() {
    }

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(int velocidad,int aceleracion, int anguloDeGiro,String patente) {
            Vehiculo vehiculo1 = new Auto(aceleracion, velocidad, anguloDeGiro, patente);
            if (vehiculos.size() < cantidadVehiculosPermitidos)
            {
                vehiculos.add(vehiculo1);
            }
            else
            {
                System.out.println("No hay más lugares disponibles en la carrera. El vehículo no podrá participar");
            }
    }

    public void darDeAltaMoto(int velocidad,int aceleracion, int anguloDeGiro,String patente) {
        Vehiculo vehiculo1 = new Moto(aceleracion, velocidad, anguloDeGiro, patente);
        if (vehiculos.size() < cantidadVehiculosPermitidos)
        {
            vehiculos.add(vehiculo1);
        }
        else
        {
            System.out.println("No hay más lugares disponibles en la carrera. El vehículo no podrá participar");
        }
    }

    public void eliminarVehiculo (Vehiculo v)
    {
        for (int i = 0; i <vehiculos.size(); i++)
        {
            if (vehiculos.get(i).getPatente().compareToIgnoreCase(v.getPatente()) == 0)
            {
                vehiculos.remove(vehiculos.get(i));
                break;
            }
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente)
    {
        for (int i = 0; i <vehiculos.size(); i++)
        {
            if (vehiculos.get(i).getPatente().compareToIgnoreCase(unaPatente) == 0)
            {
                vehiculos.remove(vehiculos.get(i));
                break;
            }
        }
    }

    public Vehiculo ganadorCarrera (List<Vehiculo> listaVehiculos)
    {
        double maximo = 0;
        Vehiculo vehiculoARetornar = null;
        for (int i = 0; i < listaVehiculos.size(); i++)
        {
            Vehiculo v = listaVehiculos.get(i);
            double valor = v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));
            if (valor > maximo) {
                maximo = valor;
                vehiculoARetornar = v;
            }
        }
        return vehiculoARetornar;
    }

    public void socorrerAuto (String patente)
    {
        Auto a = null;
        for (int i = 0; i<vehiculos.size(); i++)
        {
            if (vehiculos.get(i).getPatente().compareToIgnoreCase(patente) == 0)
            {
                a = (Auto)vehiculos.get(i);
                socorristaAuto.socorrer(a);
                break;
            }
        }
    }

    public void socorrerMoto (String patente)
    {
        Moto m = null;
        for (int i = 0; i<vehiculos.size(); i++)
        {
            if (vehiculos.get(i).getPatente().compareToIgnoreCase(patente) == 0)
            {
                m = (Moto)vehiculos.get(i);
                socorristaMoto.socorrer(m);
                break;
            }
        }
    }
}

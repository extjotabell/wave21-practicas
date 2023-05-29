import java.util.*;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private final List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
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

    public List<Vehiculo> getVehiculos() {
        return Collections.unmodifiableList(this.vehiculos);
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

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
    }

    private boolean hayCupo() {
        return this.vehiculos.size() < cantidadDeVehiculosPermitidos;
    }

    private boolean estaPantenteRepetida(String patente) {
        return this.obtenerVehiculoDadaPatente(patente) != null;
    }
    private Vehiculo obtenerVehiculoDadaPatente( String patente){
        return this.vehiculos.stream().filter(v -> v.patente.equals(patente)).findFirst().orElse(null);
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (hayCupo()) {
            if (estaPantenteRepetida(patente)) {
                System.out.println("La patente ya se encuentra registrada");
            } else {
                Auto automovil = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
                vehiculos.add(automovil);
            }
        } else {
            System.out.println("No hay cupo disponible.");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (hayCupo()) {
            if (estaPantenteRepetida(patente)) {
                System.out.println("La patente ya se encuentra registrada");
            } else {
                Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
                vehiculos.add(moto);
            }
        } else {
            System.out.println("No hay cupo disponible.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
        System.out.println("Se ha eliminado el vehículo: " + vehiculo);

    }

    public void eliminarVehiculoConPatente(String patente) {
        Vehiculo vehiculo = obtenerVehiculoDadaPatente(patente);
        if (vehiculo != null) {
            this.vehiculos.remove(vehiculo);
            System.out.println("Se ha eliminado el vehículo con patente: " + patente);
        }
    }

    public double puntajeVehiculo(double velocidad, double aceleracion, double anguloDeGiro, double peso, int ruedas) {
        return velocidad * .5 * aceleracion / (anguloDeGiro * (peso - ruedas) * 100);
    }

    public String determinarGanadorCarrera(List<Vehiculo> vehiculos) {
        HashMap<String, Double> diccionarioVehiculos = new HashMap<>();
        for (Vehiculo vehiculo : vehiculos) {
            diccionarioVehiculos.put(vehiculo.patente, puntajeVehiculo(vehiculo.velocidad, vehiculo.aceleracion, vehiculo.anguloDeGiro, vehiculo.peso, vehiculo.ruedas));
        }

        // Obtener el vehículo con el mayor puntaje
        Map.Entry<String, Double> vehiculoMayorPuntaje = diccionarioVehiculos.entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .orElse(null);

        if (vehiculoMayorPuntaje == null || vehiculoMayorPuntaje.getKey() == null) {
            return "No hay vehiculos registrados";
        } else {
            return "El vehiculo ganador es el de patente: " + vehiculoMayorPuntaje.getKey() + " con puntaje " + vehiculoMayorPuntaje.getValue();
        }
    }

    public void socorrerAuto(String patente){

        Vehiculo vehiculo = this.obtenerVehiculoDadaPatente(patente);
        if ( vehiculo instanceof Auto){
            socorristaAuto.socorrer((Auto)vehiculo);
        } else {
            System.out.println("El vehiculo registrado con esa patente no es un auto");
        }
    }

    public void socorrerMoto(String patente){
        Vehiculo vehiculo = this.obtenerVehiculoDadaPatente(patente);
        if (vehiculo instanceof Moto) {
            socorristaMoto.socorrer((Moto)vehiculo);
        } else {
            System.out.println("El vehiculo registrado con esa patente no es una moto");
        }
    }

}

package streamsYLambdas;

import java.util.List;

public class Garaje {
    //Ejercicio 1
    private int id;
    private int identificadorUnico;
    List<Vehiculo> vehiculos;

    public Garaje(int id, int identificadorUnico, List<Vehiculo> vehiculos) {
        this.id = id;
        this.identificadorUnico = identificadorUnico;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdentificadorUnico() {
        return identificadorUnico;
    }

    public void setIdentificadorUnico(int identificadorUnico) {
        this.identificadorUnico = identificadorUnico;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}

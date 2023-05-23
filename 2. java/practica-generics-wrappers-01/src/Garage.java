import java.util.List;

public class Garage {
    int id_garage;
    List<Vehiculo> vehiculos;

    public Garage(int id_garage, List<Vehiculo> vehiculos) {
        this.id_garage = id_garage;
        this.vehiculos = vehiculos;
    }

    public int getId_garage() {
        return id_garage;
    }

    public void setId_garage(int id_garage) {
        this.id_garage = id_garage;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> vehículos;

    public Garaje(int id) {
        this.id = id;
        this.vehículos = new ArrayList<>();
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculo() {
        return vehículos;
    }

    public void setVehículos(List<Vehiculo> vehículos) {
        this.vehículos = vehículos;
    }
}

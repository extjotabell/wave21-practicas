import java.util.List;

public class Garage {
    int id;
    List<Vehiculo> listaVehiculos;

    public int getId() {
        return id;
    }

    public Garage(int id, List<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}

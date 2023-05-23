import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
class Garaje {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Vehiculo> obtenerVehiculosPrecioMenorA(double precio) {
        return vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() < precio)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> obtenerVehiculosPrecioMayorIgualA(double precio) {
        return vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= precio)
                .collect(Collectors.toList());
    }

    public double obtenerPromedioPrecios() {
        return vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);
    }
}
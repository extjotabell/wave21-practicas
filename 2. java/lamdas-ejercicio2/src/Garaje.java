import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private Integer id ;
    private List<Vehiculo> listado = new ArrayList<>();

    public List<Vehiculo> getListado() {
        return listado;
    }

    public void setListado(List<Vehiculo> listado) {
        this.listado = listado;
    }

    public Garaje(Integer id, List<Vehiculo> listado) {
        this.listado = listado;
    }

    public void agregarVehiculo(Vehiculo auto){
        listado.add(auto);
    }

    public Garaje() {

    }



}

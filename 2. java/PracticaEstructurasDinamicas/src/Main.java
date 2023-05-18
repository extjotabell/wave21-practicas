import java.util.HashMap;

public class Main {

    Map<Integer,String> circuitoNombre = new HashMap<>();
    Map<Integer,String> circuitoDescripcion = new HashMap<>();
    Map<Integer,Integer> circuitoPrecio = new HashMap<>();
    Map<Integer,Integer> circuitoRestriccion = new HashMap<>();


    circuitoNombre.put(1,"Circuito Chico");
    circuitoNombre.put(2,"Circuito Medio");
    circuitoNombre.put(3,"Circuito Avanzado");

    circuitoDescripcion.put(1,"2 km por selva y arroyos");
    circuitoDescripcion.put(2,"5 km por selva, arroyos y barro");
    circuitoDescripcion.put(3,"10 km por selva, arroyos, barro y escalada en piedra");

    circuitoPrecio.put(1,1500);
    circuitoPrecio.put(2,2300);
    circuitoPrecio.put(3,2800);

    circuitoRestriccion.put(1,18);
    circuitoRestriccion.put(2,18);
    circuitoRestriccion.put(3,19);

}
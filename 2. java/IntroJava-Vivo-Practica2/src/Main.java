import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public class Inscripcion {
        int numeroParticipante;
    }

    public static void main(String[] args) {
        HashMap<Integer, String[]> circuitos = new HashMap<>();

        String[] circuitoChico = {"Circuito Chico", "2 km por selva y arroyos"};
        circuitos.put(1, circuitoChico);

        String[] circuitoMedio = {"Circuito Medio", "5 km por selva, arroyos, barro"};
        circuitos.put(2, circuitoMedio);

        String[] circuitoLargo = {"Circuito Largo", "10 km por selva, arroyos, barro y escalada en piedra"};
        circuitos.put(3, circuitoLargo);
        // Circuitos cargados

        // Inscripciones
        //
        // Num Inscripcion / NumCategoria / NumParticipante / Monto
        ArrayList<String[]> inscripciones = new ArrayList<>();


        // Participantes
        //
        // NumParticipante / DNI / Nombre /Apellido / Edad / Celular / NumEmergencia / GrupoSanguineo
        ArrayList<Object[]> participantes = new ArrayList<>();

        participantes.add(new Object[]{1, 12345678, "John", "Doe", 10, 1234, 12345, "B"});
        participantes.add(new Object[]{1, 12345678, "John", "Doe", 10, 1234, 12345, "B"});
        participantes.add(new Object[]{1, 12345678, "John", "Doe", 10, 1234, 12345, "B"});
        participantes.add(new Object[]{1, 12345678, "John", "Doe", 10, 1234, 12345, "B"});

        //Float.parseFloat(num);
    }
}



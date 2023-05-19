import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        Map<String, String> categoria1 = new HashMap<>() {{
            put("id", "circuito1");
            put("nombre", "Circuito Chico");
            put("descripcion", "2km, selva y arroyos");
        }};
        Map<String, String> categoria2 = new HashMap<>() {{
            put("id", "circuito2");
            put("nombre", "Circuito Medio");
            put("descripcion", "5km, selva, arroyos y barro");
        }};
        Map<String, String> categoria3 = new HashMap<>() {{
            put("id", "circuito3");
            put("nombre", "Circuito Avanzado");
            put("descripcion", "10km, selva, arroyos, barro y escalada");
        }};

        Participante participante1 = new Participante(1, 1, "Juan", "Perez", 14, 1, 1, "A+");
        Participante participante2 = new Participante(2, 1, "Rodrigo", "Gimenez", 15, 1, 1, "A+");
        Participante participante3 = new Participante(3, 1, "Francisco", "Gomez", 25, 1, 1, "A+");

        HashMap<?, ?> inscripto1 = new HashMap<>() {{
            put("categoria", categoria1.get("id"));
            put("participante", participante1.getNumero_participante());
            put("valor", participante1.calcularInscripcion((HashMap) categoria1));
        }};
        HashMap<?, ?> inscripto2 = new HashMap<>() {{
            put("categoria", categoria2.get("id"));
            put("participante", participante2.getNumero_participante());
            put("valor", participante2.calcularInscripcion((HashMap) categoria2));
        }};
        HashMap<?, ?> inscripto3 = new HashMap<>() {{
            put("categoria", categoria3.get("id"));
            put("participante", participante3.getNumero_participante());
            put("valor", participante3.calcularInscripcion((HashMap) categoria3));
        }};

        List<HashMap<?, ?>> inscripciones = new ArrayList<>();

        inscripciones.add(inscripto1);
        inscripciones.add(inscripto2);
        inscripciones.add(inscripto3);


        System.out.println(inscripto1);
        System.out.println(inscripto2);
        System.out.println(inscripto3);

        System.out.println(inscripciones);

        List<HashMap> inscriptos_categoria_1 = new ArrayList<>();

        for (HashMap inscripcion : inscripciones) {
            if (inscripcion.get("categoria").equals("circuito1")) {
                inscriptos_categoria_1.add(inscripcion);
            }
        }

        System.out.println(inscriptos_categoria_1);

    }


}
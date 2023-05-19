import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Map<String, Object>> categorias = new ArrayList<>();
        ArrayList<Map<String, Object>> partcipantes = new ArrayList<>();
        ArrayList<Map<String, Object>> inscripciones = new ArrayList<>();


        int montoTotal = 0;
        ArrayList<Map<String, Object>> participantesInscrito = new ArrayList<>();


        //Categorias
        Map<String, Object> categoriaChico = new HashMap<>();
        categoriaChico.put("id", 1);
        categoriaChico.put("nombre", "Circuito chico");
        categoriaChico.put("descripcion", "2 km por selva y arroyos");

        Map<String, Object> categoriaMedio = new HashMap<>();
        categoriaChico.put("id", 2);
        categoriaChico.put("nombre", "Circuito medio");
        categoriaChico.put("descripcion", "5 km por selva, arroyos y barro");

        Map<String, Object> categoriaAvanzado = new HashMap<>();
        categoriaChico.put("id", 3);
        categoriaChico.put("nombre", "Circuito avanzado");
        categoriaChico.put("descripcion", "10 km por selva, arroyos, barro y escalada en piedra");

        //Participantes
        Map<String, Object> participante1 = new HashMap<>();
        participante1.put("numero", 1);
        participante1.put("dni", "123456789");
        participante1.put("nombre", "Juan");
        participante1.put("apellido", "Orlando");
        participante1.put("edad", 19);
        participante1.put("celular", "987654321");
        participante1.put("numeroEmg", "123456789");
        participante1.put("grupoSanguineo", "O+");
        partcipantes.add(participante1);

        Map<String, Object> participante2 = new HashMap<>();
        participante2.put("numero", 2);
        participante2.put("dni", "87654321");
        participante2.put("nombre", "María");
        participante2.put("apellido", "Gómez");
        participante2.put("edad", 17);
        participante2.put("celular", "987654321");
        participante2.put("numEmergencia", "123456789");
        participante2.put("grupoSanguineo", "A-");
        partcipantes.add(participante2);

        Map<String, Object> participante3 = new HashMap<>();
        participante3.put("numero", 3);
        participante3.put("dni", "23456789");
        participante3.put("nombre", "Pedro");
        participante3.put("apellido", "López");
        participante3.put("edad", 12);
        participante3.put("celular", "567890123");
        participante3.put("numEmergencia", "432109876");
        participante3.put("grupoSanguineo", "B+");
        partcipantes.add(participante3);

        for(Map<String, Object> participante : partcipantes){
            int randomCategoria = random.nextInt(3) + 1;
            int idParticipante = (int)participante.get("numero");
            int edadParticipante = (int)participante.get("edad");
            int monto = 0;
            Map<String, Object> inscripcion = new HashMap<>();

            inscripcion.put("numeroInscripcion", idParticipante);
            inscripcion.put("categoriaId", randomCategoria);

            if(edadParticipante < 18 && randomCategoria == 3) break;
            if(randomCategoria == 1) monto = edadParticipante < 18 ? 1300 : 1500;
            if(randomCategoria == 2) monto = edadParticipante < 18 ? 2000 : 2300;
            if(randomCategoria == 3) monto = 2800;
            inscripcion.put("monto", monto);
            inscripciones.add(inscripcion);
        }

        for(Map<String, Object> inscripcion : inscripciones) {
            if((int)inscripcion.get("categoriaId") == 1) {
                montoTotal += (int)inscripcion.get("monto");
                int numeroInscripcion = (int)inscripcion.get("numeroInscripcion");

                for(Map<String, Object> participante : partcipantes) {
                    if((int)participante.get("numero") == numeroInscripcion){
                        participantesInscrito.add(participante);
                    }
                }
            }
        }
        System.out.println("Categoria 1: ");
        System.out.println("Monto: " + montoTotal);
        System.out.println("Participantes: " + participantesInscrito);
        montoTotal = 0;
        participantesInscrito = new ArrayList<>();

        for(Map<String, Object> inscripcion : inscripciones) {
            if((int)inscripcion.get("categoriaId") == 2) {
                montoTotal += (int)inscripcion.get("monto");
                int numeroInscripcion = (int)inscripcion.get("numeroInscripcion");

                for(Map<String, Object> participante : partcipantes) {
                    if((int)participante.get("numero") == numeroInscripcion){
                        participantesInscrito.add(participante);
                    }
                }
            }
        }
        System.out.println("Categoria 2: ");
        System.out.println("Monto: " + montoTotal);
        System.out.println("Participantes: " + participantesInscrito);
        montoTotal = 0;
        participantesInscrito = new ArrayList<>();

        for(Map<String, Object> inscripcion : inscripciones) {
            if((int)inscripcion.get("categoriaId") == 3) {
                montoTotal += (int)inscripcion.get("monto");
                int numeroInscripcion = (int)inscripcion.get("numeroInscripcion");

                for(Map<String, Object> participante : partcipantes) {
                    if((int)participante.get("numero") == numeroInscripcion){
                        participantesInscrito.add(participante);
                    }
                }
            }
        }
        System.out.println("Categoria 3: ");
        System.out.println("Monto: " + montoTotal);
        System.out.println("Participantes: " + participantesInscrito);

    }
}
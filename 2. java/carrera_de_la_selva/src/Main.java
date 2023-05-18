import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        List<Participante> listaParticipantes = new ArrayList<Participante>();
        List<Categoria> listaCategorias = new ArrayList<Categoria>();
        Map<Participante,Inscripcion> inscripciones = new LinkedHashMap<>();

        int cantidad=8;

        Participante p1 = new Participante(1,"1013555222","Laura","Sanabria",25,"+572154677875","+57184821544","AB-");
        Participante p2 = new Participante(2, "123456789", "Mechi", "Magnelli", 23, "12345", "54321", "Roja");
        Participante p3 = new Participante(1, "172873782", "Fran","Lecaros",28,"786324872","2736912","no se");
        Participante p4 = new Participante(4, "2336729233",  "Jose Juan", "Duron", 15,  "4491234567", "4491234567",  "O+");

        listaParticipantes.add(p1);
        listaParticipantes.add(p2);
        listaParticipantes.add(p3);
        listaParticipantes.add(p4);

        Categoria c1 = new Categoria(1,"chico","2 km por selva y arroyos");
        Categoria c2 = new Categoria(2,"medio","5 km por selva, arroyos y barro");
        Categoria c3 = new Categoria(3, "alta", "0 km por selva, arroyos, barro y escalada en piedra.");

        listaCategorias.add(c1);
        listaCategorias.add(c2);
        listaCategorias.add(c3);

        Inscripcion i1 = new Inscripcion(1,c2,p1);

        inscripciones.put(i1.getParticipante(),i1);

        Random random = new Random();
        int participanteAleatorio,categoriaAleatoria;

        int id=2;
        for(int i=0;i<cantidad;i++){
            participanteAleatorio = random.nextInt(listaParticipantes.size());
            categoriaAleatoria=random.nextInt(listaCategorias.size());
            if(!inscripciones.containsKey(listaParticipantes.get(participanteAleatorio))){
                inscripciones.put(listaParticipantes.get(participanteAleatorio),new Inscripcion(id++,listaCategorias.get(categoriaAleatoria),listaParticipantes.get(participanteAleatorio)));
                if(inscripciones.get(listaParticipantes.get(participanteAleatorio)).getMonto()==0.0){
                    inscripciones.remove(listaParticipantes.get(participanteAleatorio));
                }
            }
        }
        System.out.println("----------------------INSCRIPCIONES-------------------");
        for(Map.Entry<Participante,Inscripcion> registro : inscripciones.entrySet()){
            System.out.println("Participante:"+registro.getKey().imprimirParticipante());
            System.out.println("Inscripcion:"+registro.getValue().imprimirInscripcion());
        }
        System.out.println();

        inscripciones.remove(listaParticipantes.get(random.nextInt(inscripciones.size())));

        System.out.println("----------------------INSCRIPCIONES-------------------");
        for(Map.Entry<Participante,Inscripcion> registro : inscripciones.entrySet()){
            System.out.println("Participante:"+registro.getKey().imprimirParticipante());
            System.out.println("Inscripcion:"+registro.getValue().imprimirInscripcion());
        }
        System.out.println();

    }
}
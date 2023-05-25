import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Categoria> listaCategorias = new ArrayList<Categoria>();
        List<Participante> listaParticipantes = new ArrayList<Participante>();

        listaCategorias.add(new Categoria("Circuito chico", "2 km por selva y arroyos", 0 ));
        listaCategorias.add(new Categoria("Circuito medio", "5 km por selva, arroyos y barro", 1 ));
        listaCategorias.add(new Categoria("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra", 2 ));

        listaParticipantes.add(new Participante(18, "Pepe", "Diaz", 33333333, 1, 123123132, 123123123, "B-"));
        listaParticipantes.add(new Participante(17, "test", "Diaz", 33333333, 2, 123123132, 123123123, "B-"));
        listaParticipantes.add(new Participante(19, "test2", "Diaz", 33333333, 3, 123123132, 123123123, "B-"));
        listaParticipantes.add(new Participante(20, "test3", "Diaz", 33333333, 4, 123123132, 123123123, "B-"));


    }

    public static class Participante{
        int edad;
        String nombre;
        String apellido;
        int dni;
        int numeroParticipante;
        int celular;
        int numeroEmergencia;
        String grupoSanguineo;


        public Participante(int edad, String nombre, String apellido, int dni, int numeroParticipante, int celular, int numeroEmergencia, String grupoSanguineo) {
            this.edad = edad;
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
            this.numeroParticipante = numeroParticipante;
            this.celular = celular;
            this.numeroEmergencia = numeroEmergencia;
            this.grupoSanguineo = grupoSanguineo;
        }
    }

    public static class Categoria{
        String nombre;
        String descripcion;
        int id;

        public Categoria(String n, String d, int i) {
            nombre = n;
            descripcion = d;
            id = i;
        }
    }

    public static class Inscripcion{
        int numero;
        Categoria cat;
        Participante part;
        int monto;
    }


}
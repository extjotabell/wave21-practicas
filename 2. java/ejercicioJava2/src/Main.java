import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Categoria cat1 = new Categoria(1, "Circuito chico", "2 km por selva y arroyos");
        Categoria cat2 = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Categoria cat3 = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        Participante p1 = new Participante(1, 11111, "Juan", "Perez", 16, 15293939, 15989393,  "RH+", 1 );
        Participante p2 = new Participante(2, 22222, "Miguel", "Gonzalez", 13, 15293939, 15989393,  "RH+", 2 );
        Participante p3 = new Participante(3, 33333, "Pedro", "vizcarra", 21, 15293939, 15989393,  "RH+", 2 );
        Participante p4 = new Participante(4, 44444, "Gabriel", "Pucci", 24, 15293939, 15989393,  "RH+", 3 );
        Participante p5 = new Participante(5, 55555, "Tamara", "Perez", 21, 15293939, 15989393,  "RH+", 3 );
        Participante p6 = new Participante(6, 66666, "Francisco", "rivendell", 32, 15293939, 15989393,  "RH+", 1 );

        List<Participante> ingresantes = new ArrayList<>();
        ingresantes.add(p1);
        ingresantes.add(p2);
        ingresantes.add(p3);
        ingresantes.add(p4);
        ingresantes.add(p5);
        ingresantes.add(p6);

        for(int i = 0 ; i < ingresantes.size() ; i++){
            System.out.println("El participante nº "+ (i+1) +" de la categoria: "+ ingresantes.get(i).getCategoria() +
                    " edad" +
                    ":" + ingresantes.get(i).getEdad() + " abonara: "+ ingresantes.get(i).calcularMonto() );
        }

    }
}
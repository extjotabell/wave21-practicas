import entity.Category;
import entity.Competitor;
import entity.Inscription;
import service.InscriptionService;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Inicializacion de competidores
        List<Competitor> competitors = new ArrayList<>();
        competitors.add(new Competitor(1, "Juan", "Gomez", 23, "5.064.861-4", "+598098156283", "0-", "1727"));
        competitors.add(new Competitor(2, "Pedro", "Perez", 17, "5.164.861-4", "+598098156284", "0+", "1727"));
        competitors.add(new Competitor(3, "Pepe", "Gonzalez", 22, "5.264.861-4", "+598098156285", "0-", "1727"));
        competitors.add(new Competitor(4, "Jose", "Fernandez", 23, "5.364.861-4", "+598098156283", "0-", "1727"));
        competitors.add(new Competitor(5, "Manuel", "Coco", 16, "5.464.861-4", "+598098156283", "0-", "1727"));
        competitors.add(new Competitor(6, "Ignacio", "Machado", 28, "5.564.861-4", "+598098156283", "0-", "1727"));
        competitors.add(new Competitor(7, "Fernanda", "Flores", 18, "5.664.861-4", "+598098156283", "0-", "1727"));
        competitors.add(new Competitor(8, "Paula", "Gonzalez", 23, "5.764.861-4", "+598098156283", "0-", "1727"));
        competitors.add(new Competitor(9, "Nicolas", "Ferrari", 27, "5.864.861-4", "+598098156283", "0-", "1727"));
        competitors.add(new Competitor(10, "Carmen", "Electra", 45, "5.964.861-4", "+598098156283", "0-", "1727"));

        //Lista de inscripciones
        Collection<Inscription> inscriptions = new ArrayList<>();

        //Inscribe a los competidores en las distintas categorias
        InscriptionService.getInstance().addRandomInscriptions(inscriptions, competitors);

        //Imprime en pantalla con la informacion de todas las inscripciones de una categoria
        InscriptionService.getInstance().printInscriptionByCategory(inscriptions, new SecureRandom().nextInt(3) + 1);

        //Desinscribe un competidor de la carrera
        InscriptionService.getInstance().unsubscribeCompetitor(inscriptions, competitors.get(new SecureRandom().nextInt(10)));

        //Imprime en pantalla la cantidad recaudada por categoria y total de la carrera
        InscriptionService.getInstance().printAmountCollected(inscriptions);
    }
}
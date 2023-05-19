package service;

import entity.Competitor;
import entity.Inscription;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.List;

public class InscriptionService {
    //Singleton
    private InscriptionService(){};
    private static InscriptionService instance = new InscriptionService();
    public static InscriptionService getInstance() { return InscriptionService.instance; }

    //Inscribe a los competidores en las distintas categorias
    public void addRandomInscriptions(Collection<Inscription> inscriptions, List<Competitor> competitors){
        //Al menos un competidor por circuito
        inscriptions.add(new Inscription(CategoryService.getInstance().getCategoryById(1), competitors.get(0)));
        inscriptions.add(new Inscription(CategoryService.getInstance().getCategoryById(2), competitors.get(1)));
        inscriptions.add(new Inscription(CategoryService.getInstance().getCategoryById(3), competitors.get(2)));

        //Las inscripciones se generan en categorias random
        for (int i = 3; i < competitors.size(); i++) {
            inscriptions.add(new Inscription(
                                CategoryService.getInstance().getCategoryById(new SecureRandom().nextInt(3) + 1),
                                competitors.get(i)));
        }
    }

    //Imprime en pantalla con la informacion de todas las inscripciones de la categoria con id = categoryId
    public void printInscriptionByCategory(Collection<Inscription> inscriptions, int categoryId){
        System.out.println("Id de categoria: " + categoryId);
        for (Inscription inscription: inscriptions) {
            if(inscription.getCategoryId() == categoryId) System.out.println(inscription.getInformation());
        }
    }

    //Desinscribe al competidor competitor de la carrera
    public void unsubscribeCompetitor(Collection<Inscription> inscriptions, Competitor competitor){
        System.out.println("Competidor a desincribir: " + competitor.getName() + " " + competitor.getLastName());

        //Buscar la inscipcion del competidor
        Inscription toRemove = null;
        for (Inscription inscription: inscriptions) {
            if(inscription.getCompetitor() != null && inscription.getCompetitor().equals(competitor)){
                toRemove = inscription;
                break;
            }
        }

        if(toRemove == null) { // El competidor no estaba inscripto
            System.out.println("El competidor no se encontraba inscripto a ningun circuito");
        }else { // Eliminamos la inscipcion del competidor
            inscriptions.remove(toRemove);
            this.printInscriptionByCategory(inscriptions, toRemove.getCategoryId());
        }
    }

    //Imprime en pantalla la cantidad recaudada por categoria y total de la carrera
    public void printAmountCollected(Collection<Inscription> inscriptions){
        int categorySmall = 0;
        int categoryMedium = 0;
        int categoryAdvanced = 0;
        int total = 0;

        for (Inscription inscription: inscriptions) {
            switch (inscription.getCategoryId()){
                case 1: // Categoria circuito chico
                    categorySmall += inscription.getAmountToPay();
                    break;
                case 2: // Categoria circuito medio
                    categoryMedium += inscription.getAmountToPay();
                    break;
                case 3: // Categoria circuito avanzado
                    categoryAdvanced += inscription.getAmountToPay();
                    break;
                default:
                    //do nothing
            }

            total += inscription.getAmountToPay();
        }

        System.out.println("Cantidad recaudada en circuito chico: $" + categorySmall);
        System.out.println("Cantidad recaudada en circuito medio: $" + categoryMedium);
        System.out.println("Cantidad recaudada en circuito avanzado: $" + categoryAdvanced);
        System.out.println("Cantidad recaudada total: $" + total);
    }
}

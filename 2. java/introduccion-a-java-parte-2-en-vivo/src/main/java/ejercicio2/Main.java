package ejercicio2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final String NO_MINORS_ALLOWED_IN_THIS_CATEGORY = "No se permiten inscripciones a menores de 18 años en esta categoría";
    private static final String COMPETITOR_IS_ALREADY_ENROLLED = "El participante ya está inscrito";
    private static Map<Competitor, InscriptionCategoryWrapper> totalInscriptions = new HashMap<>();
    public static void main(String[] args) {
        //Punto a) del ejercicio
        Category category1 = new Category(1,  "Circuito chico", "2 km por selva y arroyos.");
        Category category2 = new Category(2,  "Circuito medio", "5 km por selva, arroyos y barro.");
        Category category3 = new Category(3,  "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        Competitor competitor1 = new Competitor();
        competitor1.setCompetitorNumber(1);
        competitor1.setCompetitorDNI("1111111-1");
        competitor1.setAge(18);
        competitor1.setName("Jose");
        competitor1.setLastname("Gonzalez");
        competitor1.setPhoneNumber("+56955554444");
        competitor1.setEmergencyPhoneNumber("+56955554444");
        competitor1.setBloodType("A+");
        enroll(competitor1, category3);

        //Punto c) del ejercicio
        Competitor competitor2 = new Competitor();
        competitor2.setCompetitorNumber(2);
        competitor2.setCompetitorDNI("22222222-2");
        competitor2.setAge(28);
        competitor2.setName("Rocket");
        competitor2.setLastname("Galaxy");
        competitor2.setPhoneNumber("+56955554444");
        competitor2.setEmergencyPhoneNumber("+56955554444");
        competitor2.setBloodType("B+");
        enroll(competitor2, category2);

        Competitor competitor3 = new Competitor();
        competitor3.setCompetitorNumber(3);
        competitor3.setCompetitorDNI("333333333-3");
        competitor3.setAge(12);
        competitor3.setName("Pepito");
        competitor3.setLastname("Urbina");
        competitor3.setPhoneNumber("+56955554444");
        competitor3.setEmergencyPhoneNumber("+56955554444");
        competitor3.setBloodType("C+");
        enroll(competitor3, category3);

        Competitor competitor4 = new Competitor();
        competitor4.setCompetitorNumber(4);
        competitor4.setCompetitorDNI("444444444-4");
        competitor4.setAge(15);
        competitor4.setName("Juan");
        competitor4.setLastname("Perez");
        competitor4.setPhoneNumber("+56955554444");
        competitor4.setEmergencyPhoneNumber("+56955554444");
        competitor4.setBloodType("B+");
        enroll(competitor4,category1);

        Competitor competitor5 = new Competitor();
        competitor5.setCompetitorNumber(5);
        competitor5.setCompetitorDNI("55555555-5");
        competitor5.setAge(18);
        competitor5.setName("Lucas");
        competitor5.setLastname("Espinoza");
        competitor5.setPhoneNumber("+56955554444");
        competitor5.setEmergencyPhoneNumber("+56955554444");
        competitor5.setBloodType("A+");
        enroll(competitor5, category1);

        //Punto b) del ejercicio (caso doble inscripción)
        enroll(competitor5, category1);

        //Punto d) del ejercicio
        printFromASpecificCategory(category3);

        //Punto e) del ejercicio
        printFromASpecificCategory(category1);
        removeEnroll(competitor5);
        printFromASpecificCategory(category1);

        //Punto f) del ejercicio
        calculateAmounts();
    }

    private static void enroll(Competitor competitor, Category category){
        //calculating amount to pay
        Integer age = category.getId() != 3 ? Integer.valueOf(competitor.getAge()) : competitor.getAge() < 18 ? null : competitor.getAge();
        int amountToPay = 0;
        if(age != null){
            switch (category.getId()){
                case 1:
                    amountToPay = age < 18 ? 1300 : 1500;
                    break;
                case 2:
                    amountToPay = age < 18 ? 2000 : 2300;
                    break;
                case 3:
                    amountToPay = 2800;
                    break;
            }

            //enrolling
            if(!totalInscriptions.containsKey(competitor)){
                Random randomNumber = new Random();
                Inscription newInscription = new Inscription(randomNumber.nextInt(), category.getId(), competitor.getCompetitorNumber(), amountToPay);
                InscriptionCategoryWrapper item = new InscriptionCategoryWrapper(newInscription, category);
                totalInscriptions.put(competitor,item);
                System.out.println(competitor.getName() + " se ha inscrito con éxito en la categoría: " + category.getName());
            }else{
                System.out.println(COMPETITOR_IS_ALREADY_ENROLLED);
            }

        }else{
            System.out.println(NO_MINORS_ALLOWED_IN_THIS_CATEGORY);
        }
    }

    private static void removeEnroll(Competitor competitor){
        totalInscriptions.remove(competitor);
        System.out.println("El participante " + competitor.getName() + " ya no está inscrito");
    }

    private static void printFromASpecificCategory(Category category){
        System.out.println("Participantes de la categoría: " + category.getName());
        totalInscriptions.forEach((competitor,inscriptionCategoryWrapper) -> {
            if(inscriptionCategoryWrapper.getCategory().getId() == category.getId()){
                System.out.println("-------------------------------------------------\n" +
                        "Número de Participante: " + competitor.getCompetitorNumber() + "\n" +
                        "Nombre: " + competitor.getName() + "\n" +
                        "Apellido: " + competitor.getLastname() + "\n" +
                        "DNI: " + competitor.getCompetitorDNI() + "\n" +
                        "Edad: " + competitor.getAge() + "\n" +
                        "Telefono: " + competitor.getPhoneNumber() + "\n" +
                        "Telefono de Emergencia: " + competitor.getEmergencyPhoneNumber() + "\n" +
                        "Tipo de Sangre: " + competitor.getBloodType() + "\n" +
                        "Número de Inscripción: " + inscriptionCategoryWrapper.getInscription().getInscriptionNumber() + "\n");

            }
        });
    }

    private static void calculateAmounts(){
        AtomicInteger totalCategory1 = new AtomicInteger();
        AtomicInteger totalCategory2 = new AtomicInteger();
        AtomicInteger totalCategory3 = new AtomicInteger();

        totalInscriptions.forEach(((competitor, inscriptionCategoryWrapper) -> {
            if(inscriptionCategoryWrapper.getCategory().getId() == 1){
                totalCategory1.addAndGet(inscriptionCategoryWrapper.getInscription().getAmountToPay());
            }else if(inscriptionCategoryWrapper.getCategory().getId() == 2){
                totalCategory2.addAndGet(inscriptionCategoryWrapper.getInscription().getAmountToPay());
            }else{
                totalCategory3.addAndGet(inscriptionCategoryWrapper.getInscription().getAmountToPay());
            }
        }));
        System.out.println("------------------------------------------------\n" +
                "Totales\n" +
                "Total para la Categoría 1: " + totalCategory1 + "\n" +
                "Total para la Categoría 2: " + totalCategory2 + "\n" +
                "Total para la Categoría 3: " + totalCategory3 + "\n" +
                "Total: " + (totalCategory1.get() + totalCategory2.get() + totalCategory3.get()));
    }
}

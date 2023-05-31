package org.example;

public class Main {
    public static void main(String[] args) {
        // Crea las categorías
        Category smallCircuit = new Category(1, "Circuito chico", "2 km por selva y arroyos");
        Category mediumCircuit = new Category(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Category advancedCircuit = new Category(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        // Crea los participantes
        Participant participant1 = new Participant(1, "12345678", "Juan", "Perez", 21, "1234567890", "0987654321", "A");
        Participant participant2 = new Participant(2, "87654321", "Maria", "Gonzalez", 17, "0987654321", "1234567890", "B");

        // Crea la carrera
        JungleRace jungleRace = new JungleRace();

        // Añade las categorías a la carrera
        jungleRace.addCategory(smallCircuit);
        jungleRace.addCategory(mediumCircuit);
        jungleRace.addCategory(advancedCircuit);

        // Inscribir los participantes en las categorías
        jungleRace.addParticipantToCategory(participant1, smallCircuit);
        jungleRace.addParticipantToCategory(participant2, mediumCircuit);

        // Calcular el monto total recaudado por cada categoría
        System.out.println("Monto total Circuito chico: " + jungleRace.calculateTotalAmountByCategory(smallCircuit));
        System.out.println("Monto total Circuito medio: " + jungleRace.calculateTotalAmountByCategory(mediumCircuit));
        System.out.println("Monto total Circuito avanzado: " + jungleRace.calculateTotalAmountByCategory(advancedCircuit));

        // Calcular el monto total de la carrera
        System.out.println("Monto total de la carrera: " + jungleRace.calculateTotalAmount());

        // Eliminar a un participante de una categoría
        jungleRace.removeParticipantFromCategory(participant1, smallCircuit);

        // Calcular de nuevo el monto total de la carrera
        System.out.println("Monto total de la carrera después de eliminar a un participante: " + jungleRace.calculateTotalAmount());
    }
}
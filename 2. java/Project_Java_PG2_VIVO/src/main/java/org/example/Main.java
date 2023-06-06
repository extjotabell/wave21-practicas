package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Creo las categorias
        Category category1 = new Category(1, "smallCircuit", "2 km por selva y arroyos.");
        Category category2 = new Category(2, "mediumCircuit", "5 km por selva, arroyos y barro.");
        Category category3 = new Category(3, "advanceCircuit", "10 km por selva, arroyos, barro y escalada en piedra.");

        //Creo los participantes
        Participant participant1 = new Participant(1, 11111111, "Pedro1", "Rodriguez1", 38, 99999991, 88888881, "A+" );
        Participant participant2 = new Participant(2, 11111112, "Pedro2", "Rodriguez2", 17, 99999992, 88888882, "AB+" );
        Participant participant3 = new Participant(3, 11111113, "Pedro3", "Rodriguez3", 21, 99999993, 88888883, "B-" );

        //Doy de alta la inscripcion
        Inscription inscription1 = new Inscription(1, category3, participant2, 0);
        Inscription inscription2 = new Inscription(2, category2, participant1, 0);
        Inscription inscription3 = new Inscription(3, category3, participant3, 0);

        List<Inscription> inscriptionsList = new ArrayList<>();
        List<String> participantName = new ArrayList<>();


        inscribirParticipante(inscription1);
        inscribirParticipante(inscription2);
        inscribirParticipante(inscription3);

        for (int i=0; i<inscriptionsList.size(); i++) {
            if (inscriptionsList.get(i).category.categoryName.equals(category1)) {
                participantName.add(inscriptionsList.get(i).participant.userName);
            }
        }

        System.out.println("Usuario por categoria: " + participantName );

        Map<Participant, List<Inscription>> participantByCategory = inscriptionsList.stream()
                .filter(n -> n.category.categoryName.equals(category2.categoryName))
                .collect(Collectors.groupingBy(Inscription::getParticipant));

        System.out.println("Participantes por Categoria" + participantByCategory);




    }
    public static class Category{
        int id;
        String categoryName;
        String description;
        public Category(int id, String categoryName, String description) {
            this.id = id;
            this.categoryName = categoryName;
            this.description = description;
        }
        @Override
        public String toString() {
            return "Category{" +
                    "id=" + id +
                    ", categoryName='" + categoryName + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    public static class Inscription {
        int id;
        Category category;
        Participant participant;
        int amount;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public Participant getParticipant() {
            return participant;
        }

        public void setParticipant(Participant participant) {
            this.participant = participant;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public Inscription(int id, Category category, Participant participant, int amount) {
            this.id = id;
            this.category = category;
            this.participant = participant;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Inscription{" +
                    "id=" + id +
                    ", category=" + category +
                    ", participant=" + participant +
                    ", amount=" + amount +
                    '}';
        }
    }

    public static class Participant {
        int id;
        int dni;
        String userName;
        String lastName;
        int age;
        int phone;
        int emergencyPhone;
        String bloodType;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDni() {
            return dni;
        }

        public void setDni(int dni) {
            this.dni = dni;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getPhone() {
            return phone;
        }

        public void setPhone(int phone) {
            this.phone = phone;
        }

        public int getEmergencyPhone() {
            return emergencyPhone;
        }

        public void setEmergencyPhone(int emergencyPhone) {
            this.emergencyPhone = emergencyPhone;
        }

        public String getBloodType() {
            return bloodType;
        }

        public void setBloodType(String bloodType) {
            this.bloodType = bloodType;
        }

        @Override
        public String toString() {
            return "Participant{" +
                    "id=" + id +
                    ", dni=" + dni +
                    ", userName='" + userName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", phone=" + phone +
                    ", emergencyPhone=" + emergencyPhone +
                    ", bloodType='" + bloodType + '\'' +
                    '}';
        }

        public Participant(int id, int dni, String userName, String lastName, int age, int phone, int emergencyPhone, String bloodType) {
            this.id = id;
            this.dni = dni;
            this.userName = userName;
            this.lastName = lastName;
            this.age = age;
            this.phone = phone;
            this.emergencyPhone = emergencyPhone;
            this.bloodType = bloodType;
        }


    }

    public static void inscribirParticipante(Inscription inscription) {
        //Creo una lista de inscripciones
        List<Inscription> inscriptionsList = new ArrayList<Inscription>();

        if (inscription.category.categoryName.equals("smallCircuit")) {
            if (inscription.participant.age < 18) {
                inscription.amount = 1300;
                inscriptionsList.add(inscription);
            } else {
                inscription.amount = 1500;
                inscriptionsList.add(inscription);
            }
        } else if (inscription.category.categoryName.equals("mediumCircuit")) {
            if (inscription.participant.age < 18) {
                inscription.amount = 2000;
                inscriptionsList.add(inscription);
            } else {
                inscription.amount = 2300;
                inscriptionsList.add(inscription);
            }
        } else if (inscription.category.categoryName.equals("advanceCircuit")) {
            if (inscription.participant.age > 18) {
                inscription.amount = 2800;
                inscriptionsList.add(inscription);
            } else {
                System.out.println("El participante: " + inscription.participant.userName + ", es menor de 18 años y no puede inscribirse al circuito: " + inscription.category.categoryName);
            }
        }
        System.out.println("Lista de Inscriptos: " + inscriptionsList);
    }

    public static void mostrarCategoria(Category categoria) {
        List<Inscription> inscriptionsList = new ArrayList<Inscription>();
        List<String> participantName = new ArrayList<>();

        System.out.println(inscriptionsList);

        for (int i=0; i<inscriptionsList.size(); i++) {
            if (inscriptionsList.get(i).category.categoryName.equals(categoria.categoryName)) {
                participantName.add(inscriptionsList.get(i).participant.userName);
            }
        }

        System.out.println("Usuario por categoria: " + participantName );
    }
}


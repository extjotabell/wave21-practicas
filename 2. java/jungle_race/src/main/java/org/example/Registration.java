package org.example;

public class Registration {
    private int registrationNumber;
    private Category category;
    private Participant participant;
    private double amount;
    public Registration(int registrationNumber, Category category, Participant participant) {
        this.registrationNumber = registrationNumber;
        this.category = category;
        this.participant = participant;
        this.amount = calculateAmount();
    }

    private double calculateAmount() {
        if (category.getName().equals("Circuito chico")) {
            return participant.getAge() < 18 ? 1300 : 1500;
        } else if (category.getName().equals("Circuito medio")) {
            return participant.getAge() < 18 ? 2000 : 2300;
        } else if (category.getName().equals("Circuito avanzado")) {
            if(participant.getAge() < 18) {
                throw new IllegalArgumentException("No se permite inscripciones a menores de 18 años para la categoría Circuito avanzado.");
            }
            return 2800;
        }
        return 0;
    }

    // Add getters and setters

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    // toString

    @Override
    public String toString() {
        return "Registration{" +
                "registrationNumber=" + registrationNumber +
                ", category=" + category +
                ", participant=" + participant +
                ", amount=" + amount +
                '}';
    }


    // Other methods as required
}

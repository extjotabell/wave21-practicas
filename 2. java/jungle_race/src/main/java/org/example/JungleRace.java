package org.example;
import java.util.List;
import java.util.ArrayList;


public class JungleRace {
    private List<Registration> registrations;
    private List<Category> categories;

    public JungleRace() {
        this.registrations = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addParticipantToCategory(Participant participant, Category category) {
        int registrationNumber = registrations.size() + 1;
        Registration registration = new Registration(registrationNumber, category, participant);
        registrations.add(registration);
    }

    public void removeParticipantFromCategory(Participant participant, Category category) {
        registrations.removeIf(r -> r.getParticipant().getId() == participant.getId() && r.getCategory().getId() == category.getId());
    }

    public double calculateTotalAmountByCategory(Category category) {
        return registrations.stream()
                .filter(r -> r.getCategory().getId() == category.getId())
                .mapToDouble(Registration::getAmount)
                .sum();
    }

    public double calculateTotalAmount() {
        return registrations.stream()
                .mapToDouble(Registration::getAmount)
                .sum();
    }



    // Other methods as required
}

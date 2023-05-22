package exercise2;

import java.util.List;

public class Curriculum implements Printable {
    private String personDetails;
    private List<String> skills;

    public Curriculum(String personDetails, List<String> skills) {
        this.personDetails = personDetails;
        this.skills = skills;
    }

    public void print() {
        System.out.println("Printing Curriculum: ");
        System.out.println("Person Details: " + personDetails);
        System.out.println("Skills: " + String.join(", ", skills));
    }
}
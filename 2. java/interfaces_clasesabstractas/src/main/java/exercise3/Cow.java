package exercise3;

public class Cow extends Animal implements Herbivore {
    @Override
    public void makeSound() {
        System.out.println("Muuu");
    }

    @Override
    public void eatGrass() {
        System.out.println("La vaca está comiendo hierba.");
    }
}

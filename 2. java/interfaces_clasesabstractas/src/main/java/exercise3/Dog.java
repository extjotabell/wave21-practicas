package exercise3;

public class Dog extends Animal implements Carnivore {
    @Override
    public void makeSound() {
        System.out.println("Guau");
    }

    @Override
    public void eatMeat() {
        System.out.println("El perro está comiendo carne.");
    }

    @Override
    public void eatAnimal(Animal animal) {
        if (animal instanceof Herbivore) {
            System.out.println("El perro está comiendose a un herbívoro");
        } else {
            System.out.println("El perro está comiendose a un carnivoro");
        }
    }
}

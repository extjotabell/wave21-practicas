package exercise3;

public class Cat extends Animal implements Carnivore {
    @Override
    public void makeSound() {
        System.out.println("Miau");
    }

    @Override
    public void eatMeat() {
        System.out.println("El gato está comiendo carne.");
    }

    @Override
    public void eatAnimal(Animal animal) {
        if (animal instanceof Herbivore) {
            System.out.println("El gato está comiendose a un herbívoro");
        } else {
            System.out.println("El gato está comiendose a un carnivoro");
        }
    }
}
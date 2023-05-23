public class Gato extends Animal implements Carnivoro{

    @Override
    public void makeSound() {
        System.out.println("miau");
    }

    @Override
    public void eat() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Comer carne");
    }
}

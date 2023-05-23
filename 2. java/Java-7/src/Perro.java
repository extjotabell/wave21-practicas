public class Perro extends Animal implements Carnivoro{
    @Override
    public void makeSound() {
        System.out.println("guau");
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

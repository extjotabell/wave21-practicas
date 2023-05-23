public class Vaca extends Animal implements Herviboro{
    @Override
    public void makeSound() {
        System.out.println("muuu");
    }

    @Override
    public void eat() {
        this.comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("Comer hierba");
    }
}

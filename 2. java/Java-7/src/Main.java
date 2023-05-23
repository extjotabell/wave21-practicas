public class Main {
    public static void comer(Animal animal){
        animal.eat();
    }

    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.makeSound();
        comer(perro);
        gato.makeSound();
        comer(gato);
        vaca.makeSound();
        comer(vaca);

    }
}
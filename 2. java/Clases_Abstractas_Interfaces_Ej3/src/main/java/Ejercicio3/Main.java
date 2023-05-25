package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        System.out.println(perro.toString());
        System.out.println(gato.toString());
        System.out.println(vaca.toString());

        Animal perro2 = new Perro();

        perro2.comerAnimal(perro2);
    }
}
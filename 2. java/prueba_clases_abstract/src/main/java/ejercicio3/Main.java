package ejercicio3;

public class Main {
    public static void main(String[] args) {
        Gato gato1 = new Gato();
        Perro perro1 = new Perro();
        Vaca vaca1 = new Vaca();

        gato1.emitirSonido();
        perro1.emitirSonido();
        vaca1.emitirSonido();

        System.out.println(gato1.comerCarne());
        System.out.println(perro1.comerCarne());
        System.out.println(vaca1.comerHierba());

        // Pruebo creando una funcion que se llama comerAnimal, que verifica si el animal puede comer otros animales
        comerAnimal(gato1);
        comerAnimal(vaca1);



    }
    public static void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro) {
            Carnivoro carnivoro = (Carnivoro) animal;
            System.out.println(carnivoro.comerCarne());
        } else if (animal instanceof Herbivoro) {
            System.out.println("Soy un Herbivoro no como animales");
        } else {
            System.out.println("No se puede determinar que come el animal.");
        }
    }
}

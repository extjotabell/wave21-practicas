package Ejercicio3;

public class Gato extends Animal implements Carnivoro{
    public Gato() {
    }

    @Override
    public String mostrarSonido () {
        this.setSonido("Miau");
        return "Mi sonido es: " + this.getSonido();
    }
    @Override
    public String comerCarne() {
        return "como carne";
    }

    @Override
    public void comerAnimal(Animal a) {
        String comida = comerCarne();
        System.out.println("Como " + comida);
    }

    @Override
    public String toString () {
        String comida = comerCarne();
        String sonido = mostrarSonido();
        return "Soy un gato \n" + sonido + " y " + comida;
    }
}

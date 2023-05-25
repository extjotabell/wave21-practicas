package Ejercicio3;

public class Perro extends Animal implements Carnivoro{
    public Perro() {
    }

    @Override
    public String mostrarSonido () {
        this.setSonido("Guau");
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
        return "Soy un perro \n" + sonido + " y " + comida;
    }

}

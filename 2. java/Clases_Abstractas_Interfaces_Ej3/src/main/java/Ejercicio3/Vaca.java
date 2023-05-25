package Ejercicio3;

public class Vaca extends Animal implements Herbivoro{
    public Vaca() {
    }

    @Override
    public String mostrarSonido () {
        this.setSonido("Muuu");
        return "Mi sonido es: " + this.getSonido();
    }
    @Override
    public String comerHierba(){
        return "como hierba";
    }
    @Override
    public void comerAnimal(Animal a) {
        String comida = comerHierba();
        System.out.println("Como " + comida);
    }
    @Override
    public String toString () {
        String comida = comerHierba();
        String sonido = mostrarSonido();
        return "Soy una vaca \n" + sonido + " y " + comida;
    }
}

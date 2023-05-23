import clases.Gato;
import clases.Perro;
import clases.Vaca;

public class Main {
    public static void main(String[] args) {
        Gato gato= new Gato();
        Vaca vaca= new Vaca();
        Perro perro= new Perro();

        gato.comerCarne();
        vaca.comerPlantas();
        perro.comerCarne();

        perro.comerAnimal(vaca);
        vaca.comerAnimal(gato);
        gato.comerAnimal(perro);
    }
}
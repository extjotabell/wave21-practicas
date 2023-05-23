package ejercicio_3;

public interface Carnivoro {

    default void comerCarne(){
        System.out.println("Comiendo carne...");
    }

    default void comerOtro(Animal animal){
        System.out.println("Comiendo un " + animal);
    }
}

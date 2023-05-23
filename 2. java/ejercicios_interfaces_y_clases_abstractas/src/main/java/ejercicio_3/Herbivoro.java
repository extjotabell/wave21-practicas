package ejercicio_3;

public interface Herbivoro {

    default void comerHierba() {
        System.out.println("Comiendo hierva...");
    }
}

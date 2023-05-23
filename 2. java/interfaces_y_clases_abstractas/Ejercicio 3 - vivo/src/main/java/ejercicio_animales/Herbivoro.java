package ejercicio_animales;

public interface Herbivoro {
    default void comerHierba(){
        System.out.println("Estoy comiendo hierbas");
    }
}

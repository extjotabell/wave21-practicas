package ejercicio_animales;

public interface Carnivoro {
    default void comerCarne(){
        System.out.println("Estoy comiendo carne");
    }
}

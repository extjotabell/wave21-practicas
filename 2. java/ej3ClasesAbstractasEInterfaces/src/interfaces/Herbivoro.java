package interfaces;

public interface Herbivoro {
    default void comerPlantas(){
        System.out.println("Comiendo plantas...");
    }
}

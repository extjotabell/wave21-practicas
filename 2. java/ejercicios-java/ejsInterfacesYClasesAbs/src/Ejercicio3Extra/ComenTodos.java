package Ejercicio3Extra;

public interface ComenTodos{

    void comer();
    static void comerAnimal(ComenTodos obj){
        obj.comer();
    }
}

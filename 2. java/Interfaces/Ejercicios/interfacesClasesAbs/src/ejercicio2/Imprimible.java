package ejercicio2;

public interface Imprimible {
    void imprimir();
    static void imprimirDocumento(Imprimible obj){
        obj.imprimir();
    }
}
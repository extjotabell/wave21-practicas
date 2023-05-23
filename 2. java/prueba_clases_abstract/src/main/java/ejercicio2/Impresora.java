package ejercicio2;

public interface Impresora {
    static void imprimir(IImprimible doc){
        doc.imprimir();
    }
}

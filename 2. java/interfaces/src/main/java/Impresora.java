public interface Impresora {
    static void imprimir(Imprimible documento) {
        documento.print();
    }
}

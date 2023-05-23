public interface Imprimible {
    void print();

    default void print_dos(Object tipoDeArchivo ){
        System.out.println(tipoDeArchivo.toString());
    }
}

package ejercicio1;

public interface Transaccion {
    void transaccionOk(String tipo);
    void transaccionNoOk(String tipo);
}

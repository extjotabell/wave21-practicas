package ejercicio1;

public class Deposito implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Realizándose depósito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realzar depósito");
    }
}

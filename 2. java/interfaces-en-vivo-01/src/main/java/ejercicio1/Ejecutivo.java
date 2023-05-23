package ejercicio1;

public class Ejecutivo implements Deposito, Transferencia{


    @Override
    public void hacerDeposito() {
        System.out.println("Usuario Ejecutivo realizó deposito");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Usuario Ejecutivo realizó transferencia");
    }

    @Override
    public void transaccionOk(String tipo) {
        System.out.println("Usuario Ejecutivo realizó la transacción: \"" + tipo + "\" OK");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println("Usuario Ejecutivo no pudo realizar la transacción: \"" + tipo + "\"");
    }
}

package Transacciones;

public class RetiroDeEfectivo implements Transaccion {
    public void retirarDinero(){
        System.out.println("Realizando retiro de efectivo");
        transaccionOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no ok");
    }
}

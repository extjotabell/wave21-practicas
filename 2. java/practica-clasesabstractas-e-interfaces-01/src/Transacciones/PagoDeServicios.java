package Transacciones;

public class PagoDeServicios implements Transaccion{
    public void pagarServicios(){
        System.out.println("Realizando pago de servicios");
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

package Transacciones;

public class ConsultaDeSaldo implements Transaccion{
    public void consultarSaldo(){
        System.out.println("Realizando consulta");
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

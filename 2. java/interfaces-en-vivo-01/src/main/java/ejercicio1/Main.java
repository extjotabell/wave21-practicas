package ejercicio1;

public class Main {
    public static void main(String[] args) {

        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.hacerTransferencia();
        ejecutivo.hacerDeposito();
        ejecutivo.transaccionOk("Transferencia");
        ejecutivo.transaccionNoOk("Deposito");

        Basic basic = new Basic();
        basic.hacerConsultaDeSaldo();
        basic.hacerPagoDeServicio();
        basic.hacerRetiroDeEfectivo();
        basic.transaccionOk("Consulta de Saldo");
        basic.transaccionNoOk("Deposito");

        Cobrador cobrador = new Cobrador();
        cobrador.hacerConsultaDeSaldo();
        cobrador.hacerRetiroDeEfectivo();
        cobrador.transaccionOk("Retiro de Efectivo");
        cobrador.transaccionNoOk("Deposito");
    }
}

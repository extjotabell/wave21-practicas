package org.example.Ej1;

public class Basic implements ConsultaSaldo, PagoDeServicios, RetiroDeEfectivo{
    //Basic: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.

    @Override
    public void consultarSaldo(){
        System.out.println("Realizando consulta de saldo");
        int ramdom = (int)Math.floor((Math.random() * 10) + 1);
        if (ramdom > 5 ){
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    };

    @Override
    public void pagarServicios() {
        System.out.println("Realizando pago de Servicios");
        int ramdom = (int)Math.floor((Math.random() * 10) + 1);
        if (ramdom > 5 ){
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }


    @Override
    public void retirarEfectivo() {
        System.out.println("Realizando retiro de efectivo");
    }
    @Override
    public void transaccionOk() {
        System.out.println("La transacción fue realizada con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción no pudo ser realizada. Por favor, intente más tarde");
    }
}

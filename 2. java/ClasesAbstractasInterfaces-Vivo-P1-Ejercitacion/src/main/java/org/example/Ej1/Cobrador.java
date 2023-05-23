package org.example.Ej1;

public class Cobrador implements RetiroDeEfectivo, ConsultaSaldo{
    @Override
    public void consultarSaldo() {
        System.out.println("Realizando consulta de saldo");
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
        int ramdom = (int)Math.floor((Math.random() * 10) + 1);
        if (ramdom > 5 ){
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }
    //Cobradores: Realizan retiro de efectivo y consulta de saldos.

    @Override
    public void transaccionOk() {
        System.out.println("La transacción fue realizada con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción no pudo ser realizada. Por favor, intente más tarde");
    }

}

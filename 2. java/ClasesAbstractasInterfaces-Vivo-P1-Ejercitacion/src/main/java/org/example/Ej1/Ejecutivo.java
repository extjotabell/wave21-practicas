package org.example.Ej1;

public class Ejecutivo implements Deposito, Transferencia{
    //Realizan Depósitos y Transferencias.
    @Override
    public void depositar() {
        System.out.println("Realizando deposito");
        int ramdom = (int)Math.floor((Math.random() * 10) + 1);
        if (ramdom > 5 ){
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }

    @Override
    public void transferir() {
        System.out.println("Realizando transferencia");
        int ramdom = (int)Math.floor((Math.random() * 10) + 1);
        if (ramdom >= 5 ){
            transaccionOk();
        } else {
            transaccionNoOk();
        }
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

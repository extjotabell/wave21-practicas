package Ejercicio_1.clases;

import Ejercicio_1.interfaces.Deposito;
import Ejercicio_1.interfaces.Transferencia;

public class Ejecutivo extends Cliente implements Transferencia, Deposito {

    public Ejecutivo(String nombre) {
        super(nombre);
    }

    public void realizarDeposito(){
        System.out.println("Procesando deposito...");
    }
    public void realizarTransferencia(){
        System.out.println("Procesando transferencia...");
    }

    @Override
    public String transaccionOk(String tipoTrans) {
        return String.format("La %s fue realizada con exito", tipoTrans);
    }

    @Override
    public String transaccionNoOk(String tipoTrans) {
        return String.format("La %s no fue realizada con exito", tipoTrans);
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
    }
}

import Clientes.Basic;
import Clientes.Cobrador;
import Clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basic clienteBasico = new Basic();
        clienteBasico.consultarSaldo();

        Ejecutivo clienteEjecutivo = new Ejecutivo();
        clienteEjecutivo.realizarTransferencia();

        Cobrador clienteCobrador = new Cobrador();
        clienteCobrador.retirarEfectivo();
    }
}
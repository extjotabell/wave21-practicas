package ejercicio_1;

public class Main {
    public static void main(String[] args) {
        Basic usuarioBasico = new Basic();
        Cobrador usuarioCobrador = new Cobrador();
        Ejecutivo usuarioEjecutivo = new Ejecutivo();

        System.out.println("Operaciones del usuario cobrador: ");
        usuarioCobrador.obtenerSaldo();
        usuarioCobrador.retirarEfectivo();

        System.out.println("Operaciones del usuario basico: ");
        usuarioBasico.obtenerSaldo();
        usuarioBasico.pagarServicio();
        usuarioBasico.retirarEfectivo();

        System.out.println("Operaciones del usuario ejecutivo: ");
        usuarioEjecutivo.realizarDeposito();
        usuarioEjecutivo.realizarTransferencia();
    }
}

import clases.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();

        ejecutivo.hacerDeposito();
        ejecutivo.hacerTransferencia();
        ejecutivo.transaccionOk();
        ejecutivo.transaccionNoOk();
    }
}
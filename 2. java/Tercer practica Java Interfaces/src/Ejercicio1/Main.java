package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Cobradores cobrador = new Cobradores();
        Basic basic = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();

        System.out.println(cobrador.transacionOk() + " ." + cobrador.transaccionNoOk() + " ." + cobrador.consultaSaldo() + " ." + cobrador.retiro());
        System.out.println(basic.transacionOk() + " ." + basic.transaccionNoOk() + " ." + basic.consultaSaldo() + " ." + basic.retiro() + ". " + basic.pagoDeServicios()) ;
        System.out.println(ejecutivo.transacionOk() + " ." + ejecutivo.transaccionNoOk() + " ." + ejecutivo.depositos() + " ." + cobrador.retiro());
    }
}

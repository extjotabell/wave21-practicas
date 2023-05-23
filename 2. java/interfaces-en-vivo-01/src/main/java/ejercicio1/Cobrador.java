package ejercicio1;

public class Cobrador implements RetiroDeEfectivo, ConsultaDeSaldo{
    @Override
    public void hacerConsultaDeSaldo() {
        System.out.println("Usuario Cobrador consultó el saldo");
    }

    @Override
    public void hacerRetiroDeEfectivo() {
        System.out.println("Usuario Cobrador realizó retiro de efectivo");
    }

    @Override
    public void transaccionOk(String tipo) {
        System.out.println("Usuario Cobrador realizó la transacción: \"" + tipo + "\" OK");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println("Usuario Cobrador no pudo realizar la transacción: \"" + tipo + "\"");
    }
}

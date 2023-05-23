package ejercicio1;

public class Basic implements ConsultaDeSaldo, PagoDeServicio, RetiroDeEfectivo{
    @Override
    public void hacerConsultaDeSaldo() {
        System.out.println("Usuario Basic consultó el saldo");
    }

    @Override
    public void hacerPagoDeServicio() {
        System.out.println("Usuario Basic realizó pago de servicio");
    }

    @Override
    public void hacerRetiroDeEfectivo() {
        System.out.println("Usuario Basic retiró efectivo");
    }

    @Override
    public void transaccionOk(String tipo) {
        System.out.println("Usuario Basic realizó la transacción: \"" + tipo + "\" OK");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println("Usuario Basic no pudo realizar la transacción: \"" + tipo + "\"");
    }
}

public class Basic implements  Transaccion{
    private double saldo = 477798750.00;
    public void consultarSaldo(){
        System.out.println("Su saldo es de:" + this.saldo);
    }

    public void pagarServicio() {
        System.out.println("Servicio se pagó con éxito!!!");
    }

    public void retiroEfectivo() {
        System.out.println("Cantidad retirada = 122121212");
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}



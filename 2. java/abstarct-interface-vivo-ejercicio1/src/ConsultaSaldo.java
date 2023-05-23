public class ConsultaSaldo implements Transaccion{


    @Override
    public void transaccionOk() {
        System.out.println("Consultando saldo...");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("ERROR: No se pudo consultar el saldo");
    }



}

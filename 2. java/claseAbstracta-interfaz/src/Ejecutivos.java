public class Ejecutivos extends Cliente implements Transaccion{

    public Ejecutivos(String nombre){
        super(nombre);

    }

    public void realizarDeposito(){
        this.transaccionOK();
    }

    public void realizarTransferencia(){
        this.transaccionOK();
    }




}

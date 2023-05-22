public class Cobradores extends Cliente implements Transaccion{

    public Cobradores(String nombre){
        super(nombre);


    }
    public void etiroEfectivo(){

        this.transaccionOK();
    }
    public void consultaSaldo(){
        this.transaccionOK();
    }
}

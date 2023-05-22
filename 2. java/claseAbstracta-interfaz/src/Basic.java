public class Basic extends Cliente implements Transaccion{

    public Basic(String nombre){
        super(nombre);
    }

    public void consultaDeSaldo(){
        this.transaccionOK();
    }
    public void pagoServicios(){
        this.transaccionOK();
    }
    public void retiroEfectivo(){
    this.transaccionOK();}
}

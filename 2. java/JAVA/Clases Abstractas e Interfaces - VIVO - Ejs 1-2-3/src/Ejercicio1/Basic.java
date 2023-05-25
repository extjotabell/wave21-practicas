package Ejercicio1;

public class Basic implements ConsultaSaldo, PagoDeServicio, Retiro {
    @Override
    public void hacerConsultaDeSaldo() {
        /*
        if(condicion)
            transaccionOk();
        else
            transaccionNoOk();
         */
    }

    @Override
    public void pagarServicio(int monto) {
        /*
        if(condicion)
            transaccionOk();
        else
            transaccionNoOk();
         */
    }

    @Override
    public void retiroDeEfectivo(int monto) {
        /*
        if(condicion)
            transaccionOk();
        else
            transaccionNoOk();
         */
    }

    @Override
    public void transaccionOk() {
        System.out.println("La transaccion se realizo con exito!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transaccion no se pudo reallizar");

    }
}

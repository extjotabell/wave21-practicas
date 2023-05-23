package Ejercicio1;

public class Cobradores implements Retiro, ConsultaSaldo {
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
    public void hacerConsultaDeSaldo() {
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

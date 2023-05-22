package Ejercicio_1.clases;

import Ejercicio_1.interfaces.PagarServicio;
import Ejercicio_1.interfaces.RetiroEfectivo;
import Ejercicio_1.interfaces.ConsultarSaldo;

public class Cobrador extends Cliente implements ConsultarSaldo, RetiroEfectivo, PagarServicio {
    public Cobrador(String nombre) {
        super(nombre);
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Realizando consulta...");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Pagando servicio...");
    }

    @Override
    public String transaccionOk(String tipoTrans) {
        return String.format("La transaccion %s fue realizada con exito", tipoTrans);
    }

    @Override
    public String transaccionNoOk(String tipoTrans) {
        return String.format("La transaccion %s no fue realizada con exito", tipoTrans);
    }

    @Override
    public void retirarEfectivo(double monto) {
        System.out.println(String.format("Procesando retiro de efectivo..."));
    }
}

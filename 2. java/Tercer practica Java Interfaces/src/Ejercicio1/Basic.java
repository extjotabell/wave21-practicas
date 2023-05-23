package Ejercicio1;

public class Basic extends Cliente implements TransaccionBasic{
    @Override
    public String transacionOk() {
        return "Transaccion OK Basic";
    }

    @Override
    public String transaccionNoOk() {
        return "Transaccion No Ok Basic";
    }

    @Override
    public String pagoDeServicios() {
        return "Pago de servicios Basic";
    }

    @Override
    public String retiro() {
        return "Retiro Basic";
    }

    @Override
    public String consultaSaldo() {
        return "Consulta de saldo Basic";
    }
}

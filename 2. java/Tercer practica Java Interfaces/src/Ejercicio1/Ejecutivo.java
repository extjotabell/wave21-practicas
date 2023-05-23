package Ejercicio1;

public class Ejecutivo extends Cliente implements TransaccionEjecutivos{
    @Override
    public String transacionOk() {
        return "Transaccion ok Ejecutivo";
    }

    @Override
    public String transaccionNoOk() {
        return "Transaccion no oK Ejecutivo";
    }

    @Override
    public String depositos() {
        return "Deposito Ejecutivo";
    }

    @Override
    public String transferencias() {
        return "Transferencia Ejecutivo";
    }
}

package Ejercicio1;

public class Cobradores extends Cliente implements TransaccionCobradores {
    @Override
    public String transacionOk() {
       return "Transaccion ok Cobradores";
    }

    @Override
    public String transaccionNoOk() {
        return "Transaccion NO ok Cobradores";
    }

    @Override
    public String retiro() {
        return "Retiro cobradores";
    }

    @Override
    public String consultaSaldo() {
        return "Consulta saldo Cobradores";
    }
}

package com.bootcamp.wave21;
import java.util.Map;
import java.util.List;

public abstract class TipoDeCliente {

/*Realizan Depósitos y Transferencias.*/

public abstract Map<String,Transaccion> generarTransacciones();
public abstract void transaccionesHabilitadas();

}

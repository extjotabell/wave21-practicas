package com.bootcamp.wave21;

import com.bootcamp.wave21.clases.Basic;
import com.bootcamp.wave21.clases.Cobrador;
import com.bootcamp.wave21.clases.Ejecutivo;
import com.bootcamp.wave21.clases.TipoCliente;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cobrador cliente1 = new Cobrador("Juan","Mora");
        Basic cliente2 = new Basic("ALan", "Brado");
        Ejecutivo cliente3 = new Ejecutivo("Eltor","Nillo");

        cliente1.consultarSaldo();
        cliente1.retirarEfectivo();
        cliente2.pagarServicio();
        cliente2.consultarSaldo();
        cliente3.hacerTransferencia();

    }
}

package org.example;

import org.example.Reservables.Descuento;
import org.example.Reservables.Reservable;

import java.beans.DesignMode;
import java.util.ArrayList;

public class Localizador {

    private Cliente cliente;
    private double total;
    private ArrayList<Reservable> reservables;

    private Descuento descuento;

    //ESTO ACÁ, se puede solucionar con un singleton porque necesitamos el acceso al repositorio único
    //para no usar ese patrón de diseño, elijo pasarle por parámetro la instancia que voy a abrir en
    //main del repositorio (voy a instanciar sólo una);


    public Localizador(Cliente cliente, ArrayList<Reservable> reservables) {
        this.cliente = cliente;
        this.reservables = reservables;
    }

    /*public void calcularDescuento() {

        if(cliente.comproMasDeDosVeces()) { //compro dos previamente

        }else if(reservaCompleta) { //

        }else if() {

        }
    }*/
}

package com.bootcamp.wave21;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

   private Cliente cliente;
   private List<Reserva> paquetes;
   private double montoTotal;

   public Localizador(){
       paquetes = new ArrayList<>();
   }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Reserva> paquetes) {
        this.paquetes = paquetes;
    }

    public double getMontoTotal() {

        return montoTotal;
    }

    public void aplicarMontoTotal(){
        for(Reserva res : paquetes){
            montoTotal += res.getCosto();
        }
    }
    public void aplicarDescuentos(GestorCliente cli){
        double montoConDescuento = this.getMontoTotal();

        if(aplicaDescuento1(cli,this.getCliente())){
            montoConDescuento -= montoConDescuento * 0.05;
        }
        if(aplicaDescuento2(this)){
            montoConDescuento -= montoConDescuento * 0.10;
        }
        if(aplicaDescuento3(this)){
            montoConDescuento -= montoConDescuento * 0.05;
        }
        this.setMontoTotal(montoConDescuento);

    }
    private boolean aplicaDescuento1(GestorCliente gestor, Cliente cli) {

        return gestor.buscarLocalizadoresPorCliente(cli.getDni()).size() >= 2;
    }

    private boolean aplicaDescuento2(Localizador loc) {
        int hotel = 0;
        int transporte = 0;
        int comida = 0;
        int vuelo = 0;

        for (Reserva r : loc.getPaquetes()) {
            if (transporte == 0 && r instanceof ReservaTransporte) {
                transporte = 1;
            } else if (hotel == 0 && r instanceof ReservaHotel) {
                hotel = 1;
            } else if (vuelo == 0 && r instanceof ReservaVuelo) {
                vuelo = 1;
            } else if (comida == 0 && r instanceof ReservaComida) {
                comida = 1;
            }
        }
        return transporte == 1 && comida == 1 && hotel == 1 && vuelo == 1;
    }

    private boolean aplicaDescuento3(Localizador loc) {
        int hotel = 0;
        int vuelo = 0;

        for (Reserva r : loc.getPaquetes()) {
            if (r instanceof ReservaHotel) {
                hotel++;
            } else if (r instanceof ReservaVuelo) {
                vuelo++;

            }
        }
        return hotel >= 2 || vuelo >= 2;

    }
    public void agregarReserva(Reserva r){
        this.getPaquetes().add(r);
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return
                "cliente=" + cliente +
                ", paquetes=" + mostrarPaquetes() +
                ", montoTotal= $" + montoTotal
                ;
    }

    public String mostrarPaquetes(){
       String mostrar = " ";
       for(Reserva r : paquetes){
           mostrar += r.toString();
       }
       return mostrar;
    }
}

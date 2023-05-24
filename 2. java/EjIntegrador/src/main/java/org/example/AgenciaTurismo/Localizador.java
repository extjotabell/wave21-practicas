package org.example.AgenciaTurismo;

import java.util.List;

public class Localizador {
    /*Las reservas son almacenadas en localizadores,
    los cuales contienen los datos del cliente,
    el total y la reserva o varias reservas
    dependiendo del producto adquirido. */

    private Cliente cliente;

    private double total;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente, double total, List<Reserva> reservas) {
        this.cliente = cliente;
        this.total = total;
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    /*Si un cliente anteriormente adquirió al menos 2 localizadores,
    se le descontará un 5% del total para futuras compras.
Si un cliente adquiere un paquete completo que consiste en
reserva de hotel, comida, boletos de viajes, transporte,
recibirá un descuento del 10% del total de la factura.
Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje,
se aplicará un descuento de 5% en esas reservas.
*/
    public void esPaqueteCompleto(){

    }
    public void calcularTotal(){
        double costoNeto= 0;

        int cantHotel=0;
        int cantComida =0;
        int cantTransporte =0;
        int cantBoletosViaje =0;
        double sumHotel = 0;
        double sumBoletosViaje = 0;
        double sumTransporte = 0;
        double sumComida = 0;

        for (int i=0; i<this.reservas.size(); i++){
            if (this.reservas.get(i)instanceof ReservaHotel){
                cantHotel++;
                sumHotel += this.reservas.get(i).getCosto();
            } else if (this.reservas.get(i)instanceof ReservaComida){
                cantComida++;
                sumComida += this.reservas.get(i).getCosto();
            } else if (this.reservas.get(i)instanceof ReservaTransporte){
                cantTransporte++;
                sumTransporte += this.reservas.get(i).getCosto();
            } else if (this.reservas.get(i)instanceof ReservaBoletosViaje) {
                cantBoletosViaje++;
                sumBoletosViaje += this.reservas.get(i).getCosto();
            }
        };

        if (cantHotel>=2){
            sumHotel *= 0.95;
        }
        if (cantBoletosViaje>=2){
            sumBoletosViaje *= 0.95;
        }
        costoNeto = sumComida+sumHotel+sumTransporte+sumBoletosViaje;

        if (cantComida >0 && cantHotel>0 && cantTransporte>0 && cantBoletosViaje>0){
            costoNeto *=0.90;
        }
        if (this.cliente.tieneDescuento()){
            costoNeto *=0.95;
        };

        System.out.println("El total a pagar con descuentos es " + costoNeto);

    };

}

package clases;

import enums.ReservaEnum;
import repositorio.LocalizadorRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Localizador {
    Cliente cliente;
    Collection<Reserva> reservas;
    double precioTotal;
    int descuento;

    Map<ReservaEnum, Integer> tipoDeReservas;

    public double getPrecioTotal(){
        return this.precioTotal - this.precioTotal * (descuento/100.0);
    }
    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.precioTotal = 0d;
        this.descuento = 0;
        this.tipoDeReservas = new HashMap<>();
        this.reservas = new ArrayList<>();
    }

    public Localizador addReserva(Reserva... reservasParam){
        if(reservasParam == null) return this;

        for (Reserva reserva : reservasParam) {
            this.reservas.add(reserva);
            precioTotal += reserva.price;
            if(tipoDeReservas.containsKey(reserva.tipo)){
                tipoDeReservas.put(reserva.tipo, tipoDeReservas.get(reserva.tipo) + 1);
            }else {
                tipoDeReservas.put(reserva.tipo, 1);
            }
        }

        this.calcularDescuentos();
        return this;
    }

    public void calcularDescuentos(){
        int descuento = 0;
        if(tipoDeReservas.keySet().size() == 4){
            descuento += 10;
        }
        if((tipoDeReservas.containsKey(ReservaEnum.HOTEL) && tipoDeReservas.get(ReservaEnum.HOTEL) >= 2) || (tipoDeReservas.containsKey(ReservaEnum.BOLETOS_DE_VIAJE) && tipoDeReservas.get(ReservaEnum.BOLETOS_DE_VIAJE) >= 2)){
            descuento += 5;
        }
        if(LocalizadorRepo.localizadores.containsKey(this.cliente) && LocalizadorRepo.localizadores.get(this.cliente).size() > 1){
            descuento += 5;
        }

        this.descuento = descuento;
    }

    @Override
    public String toString(){
        return new StringBuilder("Cliente: ").append(this.cliente.toString()).append("\n")
                .append("Reservas: ").append(this.reservas.toString()).append("\n")
                .append("Precio total: ").append(this.getPrecioTotal()).append("\n")
                .append("Descuento: ").append(this.descuento).append("%\n")
                .toString();
    }
}

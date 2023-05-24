package clases;

import enums.ReservaEnum;

public class Reserva {
    ReservaEnum tipo;
    double price;

    public Reserva(ReservaEnum tipo, double price) {
        this.tipo = tipo;
        this.price = price;
    }

    @Override
    public String toString(){
        return new StringBuilder("Tipo: ").append(this.tipo.toString()).append(" - ")
                .append("Precio: ").append(this.price)
                .toString();
    }
}

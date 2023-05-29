package Clases;

public class Transporte extends Reserva{
    private Integer precio;

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    Transporte(Integer idReserva, String fechaReserva) {
        super(idReserva, fechaReserva);
    }

}

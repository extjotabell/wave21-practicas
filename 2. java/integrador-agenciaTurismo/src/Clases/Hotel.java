package Clases;

public class Hotel extends Reserva {
    private Integer precio;

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Hotel(Integer idReserva, String fechaReserva, Integer precio) {
        super(idReserva, fechaReserva);
        this.precio = precio;
    }


}

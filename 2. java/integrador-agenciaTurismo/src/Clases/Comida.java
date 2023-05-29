package Clases;

public class Comida extends Reserva{
    private Integer precio;

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Comida(Integer idReserva, String fechaReserva) {
        super(idReserva, fechaReserva);
    }
}

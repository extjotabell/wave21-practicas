import java.util.ArrayList;
import java.util.List;

class Cliente {
    private String nombre;
    private List<Localizador> localizadores;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    public boolean haRealizadoComprasAnteriores() {
        return localizadores.size() >= 2;
    }

    public boolean haAdquiridoPaqueteCompleto() {
        for (Localizador localizador : localizadores) {
            if (localizador.esPaqueteCompleto()) {
                return true;
            }
        }
        return false;
    }

    public boolean haAdquiridoReservasHotel() {
        for (Localizador localizador : localizadores) {
            if (localizador.esReservaHotel()) {
                return true;
            }
        }
        return false;
    }

    public boolean haAdquiridoBoletosViaje() {
        for (Localizador localizador : localizadores) {
            if (localizador.esBoletoViaje()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Cliente: " + nombre;
    }
}
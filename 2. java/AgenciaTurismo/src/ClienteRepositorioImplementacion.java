import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ClienteRepositorioImplementacion implements ClienteRepositorio {
    private ArrayList<Localizador> localizadores;

    @Override
    public ArrayList<Localizador> getLocalizadores() {
        return this.localizadores;
    }

    public ClienteRepositorioImplementacion() {
        this.localizadores = new ArrayList<>();
    }

    @Override
    public ArrayList<Localizador> localizadoresporCliente(String dni) {
        return localizadores.stream().filter(localizador -> localizador.getCliente().getDni().equals(dni))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void agregarLocalizador(Localizador localizador) {
        int contadorReservas = 0;
        int contadorReservasHotel = 0;
        int contadorReservasVoletos = 0;

        if(localizadores.size() > 2) localizador.getReservas().forEach(Reserva::descuentoCincoPorciento);

        for(Reserva reserva : localizador.getReservas()){
            if(reserva instanceof Hotel) {contadorReservas += 1; contadorReservasHotel += 1; };
            if(reserva instanceof Comida) contadorReservas += 1;
            if(reserva instanceof VoletoViaje) {contadorReservas += 1; contadorReservasVoletos += 1; };
            if(reserva instanceof Transporte) contadorReservas += 1;
        }

        if(contadorReservasHotel >= 2 && contadorReservasVoletos >= 2) localizador.getReservas().forEach(reserva -> {
            if(reserva instanceof Hotel) reserva.descuentoCincoPorciento();
            if(reserva instanceof VoletoViaje) reserva.descuentoCincoPorciento();
        });

        if(contadorReservas == 4) localizador.getReservas().forEach(Reserva::descuentoDiezPorciento);

        localizadores.add(localizador);
    }
}

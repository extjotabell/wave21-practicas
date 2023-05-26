package agencia_turismo.parte2;

import agencia_turismo.Localizador;
import agencia_turismo.Repositorio;
import agencia_turismo.Reserva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultorDeLocalizadores {
    private final Repositorio<Localizador> repoLocalizadores;

    public ConsultorDeLocalizadores(Repositorio<Localizador> repoLocalizadores) {
        this.repoLocalizadores = repoLocalizadores;
    }

    public void mostrarLocalizadoresVendidos() {
        int localizadoresVendidos = repoLocalizadores.getElementos().size();
        System.out.println("Se vendieron " + localizadoresVendidos + " localizadores");
    }

    public void mostrarReservasHechas() {
        int[] totalReservasHechas = {0};
        repoLocalizadores.getElementos().forEach(l -> totalReservasHechas[0] += l.getCantidadReservasHechas());
        System.out.println("Se realizaron un total de " + totalReservasHechas[0] + " reservas");
    }

    public Map<Class<? extends Reserva>, List<Reserva>> getReservasPorTipo() {
        Map<Class<? extends Reserva>, List<Reserva>> reservas = new HashMap<>();
        repoLocalizadores.getElementos().forEach(l -> l.getReservas().forEach((k, v) -> reservas.computeIfAbsent(k, k1 -> new ArrayList<>()).addAll(v)));
        return reservas;

    }

    public void mostrarTotalDeLasVentas() {
        double totalDeLasVentas = this.repoLocalizadores.getElementos().stream().mapToDouble(Localizador::getCostoConDescuentosAplicados).sum();
        System.out.printf("%s%.2f%n", "El valor total de las ventas realizadas es de ", totalDeLasVentas);
    }

    public void mostrarPromedioDeLasVentas() {
        double promedioDeVentas = this.repoLocalizadores.getElementos().stream().mapToDouble(Localizador::getCostoConDescuentosAplicados).average().orElse(0D);
        System.out.printf("%s%.2f%n", "El valor promedio de las ventas realizadas es de ", promedioDeVentas);
    }
}

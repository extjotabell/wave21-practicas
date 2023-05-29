import Reservas.*;

import java.util.Comparator;

public class ServiceLocalizadores {

    public static void cantidadDeLocalizadores(RepositorioLocalizador repo){
        System.out.println(repo.get().size());
    }

    public static void cantidadDeReservas(RepositorioLocalizador repo){
        System.out.println(repo.get().stream().mapToInt(localizador -> localizador.getReservaList().size()).sum());
    }
    public static void listarReservasPorTipo(RepositorioLocalizador repo) {
        System.out.println(repo.get().stream().flatMap(localizador -> localizador.getReservaList().stream()).sorted(

                Comparator.comparingInt(
                        Reserva -> {
                            if (Reserva instanceof ReservaHotel) {
                                return 1;
                            } else if (Reserva instanceof ReservaBoletoViaje) {
                                return 2;
                            } else if (Reserva instanceof ReservaComida) {
                                return 3;
                            } else if (Reserva instanceof ReservaBoletoTransporte) {
                                return 4;
                            } else return 0;
                        })
                ).toList()
        );
    }

    public static void listarVentasTotales(RepositorioLocalizador repo){
        System.out.println(repo.get().stream().mapToDouble(localizador -> localizador.getTotal()).sum());
    }

    public static void listarPromedioVentas(RepositorioLocalizador repo){

        System.out.println(repo.get().stream().mapToDouble(localizador -> localizador.getTotal()).sum()
                        /
                        repo.get().stream().count()
                );
    }
}

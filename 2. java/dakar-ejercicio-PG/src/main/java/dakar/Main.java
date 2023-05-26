package dakar;
public class Main {
    public static void main(String[] args) {

        SocorristaAuto socorristaAuto = new SocorristaAuto("Jose", "2525");
        SocorristaMoto socorristaMoto = new SocorristaMoto("Pepito", "2626");

        Carrera newCarrera = new Carrera(2500D,1000000D, "Grand Prix", 3, socorristaAuto, socorristaMoto);
        newCarrera.darDeAltaAuto(80D,40D, 90D, "ASX005");
        newCarrera.darDeAltaAuto(90D,30D, 100D, "ASX006");
        newCarrera.darDeAltaMoto(100D,50D, 30D, "ASX007");
        newCarrera.darDeAltaMoto(110D,60D, 40D, "ASX008");

        newCarrera.eliminarVehiculoConPatente("ASX008");
        newCarrera.eliminarVehiculoConPatente("ASX007");

        newCarrera.darDeAltaMoto(110D,60D, 40D, "ASX008");

        newCarrera.socorrerAuto("ASX005");
        newCarrera.socorrerMoto("ASX008");

        newCarrera.getWinner();
    }
}
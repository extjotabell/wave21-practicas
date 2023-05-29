public class Main {
    public static void main(String[] args) {
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();
        Carrera dakar = new Carrera(1000, 5900, "Dakar 2023", 9, socorristaAuto, socorristaMoto);
        dakar.darDeAltaAuto(90.0, 4.5, 50.0, "JKL012");
        dakar.darDeAltaAuto(110.0, 5.5, 35.0, "MNO345");
        dakar.darDeAltaAuto(70.0, 3.5, 70.0, "PQR678");
        dakar.darDeAltaAuto(95.0, 4.0, 55.0, "STU901");
        dakar.darDeAltaAuto(115.0, 6.5, 40.0, "VWX234");

       dakar.darDeAltaMoto(85.0, 3.0, 75.0, "YZA567");
       dakar.darDeAltaMoto(100.0, 5.0, 45.0, "BCD890");
       dakar.darDeAltaMoto(120.0, 6.0, 30.0, "EFG123");
       dakar.darDeAltaMoto(80.0, 4.0, 60.0, "HIJ456");
       dakar.darDeAltaMoto(105.0, 4.5, 50.0, "KLM789");

        dakar.eliminarVehiculoConPatente("JKL012");
        System.out.println(dakar.determinarGanadorCarrera(dakar.getVehiculos()));
    }
}

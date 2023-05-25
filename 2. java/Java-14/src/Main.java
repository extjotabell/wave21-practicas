import clases.*;

public class Main {
    public static void main(String[] args) {
        Carrera carrera= new Carrera(100, 1500, "CarreraTest", 4, new SocorristaAuto(100, 20, 2, "PatenteSocorristaAuto"), new SocorristaMoto(100, 20, 2, "PatenteSocorristaMoto"));
        carrera.darDeAltaAuto(100, 10, 2, "PatenteAuto");
        carrera.darDeAltaMoto(100, 20, 2, "PatenteMoto");
        carrera.definirGanador();

        carrera.socorrerAuto("PatenteAuto");
    }
}
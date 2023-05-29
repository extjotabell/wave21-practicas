public class SocorristaAuto {
    public void socorrer(Auto unAuto){
        if (unAuto != null) {
            System.out.println("Socorriendo Auto: " + unAuto.patente);
        } else {
            System.out.println("No se logro socorrer porque no existe");
        }
    }
}

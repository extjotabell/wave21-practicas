public class SocorristaMoto {

    public void socorrer(Moto motocicleta){
        if (motocicleta != null) {
            System.out.println("Socorriendo moto: " + motocicleta.patente);
        } else {
            System.out.println("No se logro socorrer porque no existe");
        }
    }
}

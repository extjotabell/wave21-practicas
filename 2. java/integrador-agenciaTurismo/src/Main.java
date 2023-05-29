import Clases.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    Hotel r1 = new Hotel(100,"20/3/2023", 35000);
    Comida r2 = new Comida(100, "20/03/2023");
    Cliente c1 = new Cliente(2222,"Gabriel", "antonietti");
    //creo una instancia de paquete y le agrego las reservas correspondientes, en este
        // caso solo Hotel y comida

    Localizador paquete1 = new Localizador();
    paquete1.setHotel(r1);
    paquete1.setComida(r2);
    //al mismo paquete le agrego un Cliente
     paquete1.setTurista(c1);
     //ahora para asociar el paquete con el cliente, agrego a la lista de Localizadores
        // que tiene el cliente, el paquete que acaba de comprar.
        // esto me va a permitir buscar los paquetes y hacer comparaciones;
    c1.agregarPaquete(paquete1);




    }
}
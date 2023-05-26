import java.util.ArrayList;

public interface ClienteRepositorio {
    ArrayList<Localizador> localizadoresporCliente(String dni);
    ArrayList<Localizador> getLocalizadores();
    void agregarLocalizador(Localizador localizador);

}

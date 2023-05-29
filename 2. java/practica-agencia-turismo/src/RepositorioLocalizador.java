import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador implements Repository<Localizador>{
    List<Localizador> localizadores = new ArrayList<>();
    @Override
    public Localizador findBy(String id) {
        return (Localizador) localizadores.stream().filter(localizador -> localizador.cliente.dni.equals(id));
    }

    @Override
    public void save(Localizador obj) {
        this.localizadores.add(obj);
    }

    @Override
    public List<Localizador> findAll() {
        return this.localizadores;
    }
}

package Clases;

import Interfaces.Repositorio;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador implements Repositorio<Localizador> {
    private List<Localizador> localizadores = new ArrayList<>();

    @Override
    public void agregar(Localizador localizador) {
        localizadores.add(localizador);
    }

    @Override
    public Localizador buscarPorId(String id) {
        for (Localizador localizador : localizadores) {
            if (localizador.getId().equals(id)) {
                return localizador;
            }
        }
        return null;
    }

    public long contarPorClienteId(String clienteId) {
        return localizadores.stream()
                .filter(localizador -> localizador.getCliente().getId().equals(clienteId))
                .count();
    }

    @Override
    public List<Localizador> obtenerTodos() {
        return new ArrayList<>(localizadores);
    }
}

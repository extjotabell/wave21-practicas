package repositorio;

import clases.Cliente;
import clases.Localizador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LocalizadorRepo {
    public static Map<Cliente, Collection<Localizador>> localizadores = new HashMap<>();

    public static void addNuevoLocalizador(Cliente cliente, Localizador localizador){
        Collection<Localizador> localizadors;
        if(localizadores.containsKey(cliente)){
            localizadors = localizadores.get(cliente);
        }else{
            localizadors = new ArrayList<>();
        }

        localizadors.add(localizador);
        localizadores.put(cliente, localizadors);
    }
}
